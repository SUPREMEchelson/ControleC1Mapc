package serviceprovider.api;

import cloud.api.Service;
import cloud.api.ServiceType;
import serviceprovider.impl.DefaultMonitoringService;

public interface MonitoringServiceType extends ServiceType {
    @Override
    default String serviceTypeKey(){return BasicServiceTypeNames.MONITORING.getName();}

    @Override
    default Service createService(String name){return new DefaultMonitoringService(name);}
}
