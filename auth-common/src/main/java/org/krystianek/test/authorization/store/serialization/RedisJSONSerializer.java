package org.krystianek.test.authorization.store.serialization;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by krystian on 23.10.16.
 */
public class RedisJSONSerializer implements RedisTokenStoreSerializationStrategy {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static Logger LOG = LoggerFactory.getLogger(RedisJSONSerializer.class);

    {
        mapper.getDeserializationConfig().addMixInAnnotations(OAuth2Authentication.class, OAuth2AuthenticationMixin.class);
        mapper.getDeserializationConfig().addMixInAnnotations(OAuth2Request.class, OAuth2RequestMixin.class);
        mapper.getDeserializationConfig().addMixInAnnotations(TokenRequest.class, TokenRequestMixin.class);
        mapper.getDeserializationConfig().addMixInAnnotations(GrantedAuthority.class, GrantedAuthorityMixin.class);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> aClass) {
        if (bytes == null)
            return null;
        final ObjectReader reader = mapper.reader();
        try {
            String s = new String(bytes);
            final JsonNode newNode = reader.readTree(new ByteArrayInputStream(bytes));
            return mapper.treeToValue(newNode, aClass);

        } catch (IOException e) {
            LOG.error("Unable to read the byte array {}",e);
        }
        return null;
    }

    @Override
    public String deserializeString(byte[] bytes) {
        return this.deserialize(bytes, String.class);
    }

    @Override
    public byte[] serialize(Object o) {
        final ObjectWriter writer = mapper.writer();
        byte[] bytes = null;
        try {
            bytes = writer.writeValueAsBytes(o);
        } catch (IOException e) {
            LOG.error("Unable to write the byte array {}",e);;
        }
        return bytes;
    }

    @Override
    public byte[] serialize(String s) {
        return this.serialize((Object)s);
    }
}
