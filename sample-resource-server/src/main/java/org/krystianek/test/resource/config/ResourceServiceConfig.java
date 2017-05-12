package org.krystianek.test.resource.config;

import org.krystianek.test.resource.TokenAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesUserDetailsService;

/**
 * Created by krystian on 23.10.16.
 */
@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .tokenServices(tokenServices)
                .authenticationManager(authenticationManager);
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/**")
                .and().authorizeRequests()
                .antMatchers("/user").permitAll();
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setAuthenticationManager(authenticationManager);
        return tokenServices;
    }

/*    @Bean
    PreAuthenticatedGrantedAuthoritiesUserDetailsService createUserDetailService() {
        return new PreAuthenticatedGrantedAuthoritiesUserDetailsService();
    }

    @Bean
    PreAuthenticatedAuthenticationProvider createAuthenticationProvider()
    {
        PreAuthenticatedAuthenticationProvider prov = new PreAuthenticatedAuthenticationProvider();
        prov.setPreAuthenticatedUserDetailsService(new PreAuthenticatedGrantedAuthoritiesUserDetailsService());
        return prov;

    } */

   @Bean
    AuthenticationProvider createAuthenticationProvider() {
        return new TokenAuthenticationProvider();
    }

}
