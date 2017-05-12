package org.krystianek.test.authorization.domain.provider;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by krystian on 22.10.16.
 */
public class SampleClientDetails implements ClientDetails {

    private String clientId;
    private static final String[] strArray = {"booking", "reading", "client_credentials", "vier"};
    private static final GrantedAuthority grAuth = new SampleGrantedAuthority();

    public SampleClientDetails(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return Arrays.stream(strArray).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return "secret";
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return Arrays.stream(strArray).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Arrays.stream(strArray).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Arrays.asList(grAuth);
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 3600;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 1800;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("kto to?","testowy");
        return map;
    }
}
