package org.krystianek.test.authorization.store.serialization;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.krystianek.test.authorization.domain.provider.SampleGrantedAuthority;

/**
 * Created by krystian on 23.10.16.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = SampleGrantedAuthority.class)
public abstract class GrantedAuthorityMixin {

}
