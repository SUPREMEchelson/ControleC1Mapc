package serviceprovider.impl;


import cloud.api.ServiceType;
import cloud.impl.base.ServiceImpl;
import serviceprovider.api.MonitoringServiceType;

public final class DefaultMonitoringService extends ServiceImpl implements MonitoringServiceType {
    public DefaultMonitoringService(String name) {
        super(name);
    }

    @Override
    public ServiceType getServiceType() {
        return this;
    }
}
