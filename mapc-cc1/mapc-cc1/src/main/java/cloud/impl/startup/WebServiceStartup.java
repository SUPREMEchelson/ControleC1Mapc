package cloud.impl.startup;

import cloud.impl.base.ServiceStartup;
import serviceprovider.api.BasicServiceTypeNames;

public final class WebServiceStartup extends ServiceStartup {

    public WebServiceStartup(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.WEB_SERVER.getName());
    }
}
