package org.krystianek.test.authorization.domain.provider;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by krystian on 22.10.16.
 */
public class SampleGrantedAuthority implements GrantedAuthority {

    private String authority = "KrystianCorp";

    @Override
    public String getAuthority() {
        return authority;
    }

}
