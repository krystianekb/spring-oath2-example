package org.krystianek.test.authorization.domain.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * Created by krystian on 22.10.16.
 */
public class SampleClientDetailsService implements ClientDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(SampleClientDetailsService.class);

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        LOG.info("Retrieving client data for {}", s);
        return new SampleClientDetails(s);
    }
}
