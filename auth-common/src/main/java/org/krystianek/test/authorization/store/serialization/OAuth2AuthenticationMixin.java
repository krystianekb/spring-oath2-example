package org.krystianek.test.authorization.store.serialization;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

/**
 * Created by krystian on 23.10.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class OAuth2AuthenticationMixin {

    @JsonCreator
    public OAuth2AuthenticationMixin(
            @JsonProperty("oauth2Request") OAuth2Request storedRequest,
            @JsonProperty("userAuthentication") Authentication userAuthentication) {
    }

    @JsonIgnore
    public abstract boolean isClientOnly();

    @JsonIgnore
    public abstract Object getPrincipal();

    @JsonIgnore
    public abstract Object getCredentials();

}
