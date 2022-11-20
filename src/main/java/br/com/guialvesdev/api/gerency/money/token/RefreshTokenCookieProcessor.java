package br.com.guialvesdev.api.gerency.money.token;

import javax.servlet.*;
import java.io.IOException;
import java.util.stream.Stream;

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

    static class MyServletRequest





}
