package org.krystianek.test.authorization.store.serialization;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Collection;
import java.util.Map;

/**
 * Created by krystian on 23.10.16.
 */
public abstract class TokenRequestMixin {

    @JsonCreator
    public TokenRequestMixin(
            @JsonProperty("requestParameters") Map<String, String> requestParameters,
            @JsonProperty("clientId") String clientId,
            @JsonProperty("scope") Collection<String> scope,
            @JsonProperty("grant_type") String grantType) {

    }

}
