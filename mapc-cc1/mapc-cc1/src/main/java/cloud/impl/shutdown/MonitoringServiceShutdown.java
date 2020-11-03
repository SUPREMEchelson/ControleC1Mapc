package cloud.impl.shutdown;

import cloud.impl.base.ServiceShutdown;
import serviceprovider.api.BasicServiceTypeNames;

public final class MonitoringServiceShutdown extends ServiceShutdown {

    public MonitoringServiceShutdown(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.MONITORING.getName());
    }
}
