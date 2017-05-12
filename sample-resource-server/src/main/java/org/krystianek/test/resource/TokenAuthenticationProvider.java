package org.krystianek.test.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.security.Principal;

/**
 * Created by krystian on 23.10.16.
 */
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    TokenStore store;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        OAuth2AccessToken tokenOAuth2 = store.readAccessToken((String)authentication.getPrincipal());

        if ((tokenOAuth2 != null)&&(!tokenOAuth2.isExpired())) {
            return new PreAuthenticatedAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
