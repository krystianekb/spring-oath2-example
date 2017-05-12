package org.krystianek.test.authorization.store.config;

import org.krystianek.test.authorization.store.serialization.RedisJSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Created by krystian on 22.10.16.
 */
@Configuration
public class RedisStoreConfiguration {

    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    RedisTokenStore redisTokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(factory);
        redisTokenStore.setSerializationStrategy(new RedisJSONSerializer());
        return redisTokenStore;
    }

    @Bean
    RedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("192.168.0.10");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory;
    }

}
