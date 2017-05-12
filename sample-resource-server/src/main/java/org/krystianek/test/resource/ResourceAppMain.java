package org.krystianek.test.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by krystian on 22.10.16.
 */
@SpringBootApplication
@ComponentScan("org.krystianek.test.resource,org.krystianek.test.authorization.store.config")
public class ResourceAppMain {
    public static void main(String[] args) {
        SpringApplication.run(ResourceAppMain.class, args);
    }
}
