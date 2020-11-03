package cloud.impl.shutdown;

import cloud.impl.base.ServiceShutdown;
import serviceprovider.api.BasicServiceTypeNames;

public final class WebServiceShutdown extends ServiceShutdown {

    public WebServiceShutdown(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.WEB_SERVER.getName());
    }
}
