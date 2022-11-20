package br.com.guialvesdev.api.gerency.money.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends  AuthorizationServerConfigurerAdapter  {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("angular")
                .secret("$2a$10$UAc049fUm6Bxy8X/.mpn8.PfD2ncb4ZgvmEa5Hb.JOGVJNX1ampgG") // @ngul@r0
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(1800)
                .refreshTokenValiditySeconds(3600 * 24)
        .and()
                .withClient("mobile")
                .secret(passwordEncoder.encode("m0bile")) //forma insegura
                .scopes("read")
                .authorizedGrantTypes("password", "refresh_token")
                .acessTokenValiditySeconds(1800)
                .refreshTokenValiditySeconds(3600 * 24);









    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter())
                .tokenStore(tokenStore())
                .userDetailsService(userDetailsService)
                .reuseRefreshTokens(false);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();

        accessTokenConverter.setSigningKey("3032885ba9cd6621bcc4e7d6b6c35c2b");

        return accessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore(accessTokenConverter());
    }

}
