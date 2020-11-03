package cloud.impl.startup;

import cloud.impl.base.ServiceStartup;
import serviceprovider.api.BasicServiceTypeNames;

public final class LoggingServiceStartup extends ServiceStartup {

    public LoggingServiceStartup(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.LOGGING.getName());
    }
}
