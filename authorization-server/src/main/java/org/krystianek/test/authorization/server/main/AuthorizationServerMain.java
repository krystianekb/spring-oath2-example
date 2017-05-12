package org.krystianek.test.authorization.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by krystian on 22.10.16.
 */
@SpringBootApplication
@ComponentScan("org.krystianek.test.authorization.server,org.krystianek.test.authorization.store.config")
public class AuthorizationServerMain {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerMain.class, args);
    }
}
