package org.krystianek.test.authorization.store.serialization;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by krystian on 23.10.16.
 */
public abstract class OAuth2RequestMixin {

    @JsonCreator
    public OAuth2RequestMixin(
            @JsonProperty("requestParameters") Map<String, String> requestParameters,
            @JsonProperty("clientId") String clientId,
            @JsonProperty("authorities") Collection<? extends GrantedAuthority > authorities,
            @JsonProperty("approved") boolean approved,
            @JsonProperty("scope") Collection<String> scope,
            @JsonProperty("resourceIds") Set<String> resourceIds,
            @JsonProperty("redirectUri") String redirectUri,
            @JsonProperty("responseTypes") Set<String> responseTypes,
            @JsonProperty("extensions") Map<String, Serializable > extensionProperties) {
    }

    @JsonProperty("refreshTokenRequest")
    public abstract OAuth2Request refresh(TokenRequest tokenRequest);

    @JsonIgnore
    public abstract boolean isRefresh();

    @JsonIgnore
    public abstract String getGrantType();

}
