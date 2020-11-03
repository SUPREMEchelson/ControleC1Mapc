package cloud.impl.startup;

import cloud.impl.base.ServiceStartup;
import serviceprovider.api.BasicServiceTypeNames;

public final class MonitoringServiceStartup extends ServiceStartup {

    public MonitoringServiceStartup(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.MONITORING.getName());
    }
}
