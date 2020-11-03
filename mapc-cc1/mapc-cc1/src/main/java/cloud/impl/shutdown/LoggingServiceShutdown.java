package cloud.impl.shutdown;

import cloud.impl.base.ServiceShutdown;
import serviceprovider.api.BasicServiceTypeNames;

public final class LoggingServiceShutdown extends ServiceShutdown {

    public LoggingServiceShutdown(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.LOGGING.getName());
    }
}
