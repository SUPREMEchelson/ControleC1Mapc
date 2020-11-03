package cloud.impl.shutdown;

import cloud.impl.base.ServiceShutdown;
import serviceprovider.api.BasicServiceTypeNames;

public final class ApplicationServiceShutdown extends ServiceShutdown {

    public ApplicationServiceShutdown(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.APP_SERVER.getName()

        );
    }
}
