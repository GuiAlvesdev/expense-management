package br.com.guialvesdev.api.gerency.money.token;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookieProcessor implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if ("/oauth/token".equalsIgnoreCase(req.getRequestURI())
                && "refresh_token".equals(req.getParameter("grant_type"))
                && req.getCookies() != null) {

            String refreshToken =
                    Stream.of(req.getCookies())
                            .filter(cookie -> "refreshToken".equals(cookie.getName()))
                            .findFirst()
                            .map(cookie -> cookie.getValue())
                            .orElse(null);

            req = new MyServletRequestWrapper(req, refreshToken);
        }

        chain.doFilter(req, response);
    }

    static class MyServletRequest extends HttpServletRequestWrapper{

        private String refreshToken;


        public MyServletRequest(HttpServletRequest request, String refreshToken) {
            super(request);
            this.refreshToken = refreshToken;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            ParameterMap<String, String []> map = new ParameterMap<>(getRequest().getParameterMap());
            map.put("refresh_token", new String[] {refreshToken});
            map.setLocked(true);
            return map;
        }
    }





}
