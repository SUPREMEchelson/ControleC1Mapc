package cloud.impl.startup;

import cloud.impl.base.ServiceStartup;
import serviceprovider.api.BasicServiceTypeNames;

public final class ApplicationServiceStartup extends ServiceStartup {

    public ApplicationServiceStartup(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.APP_SERVER.getName());
    }
}
