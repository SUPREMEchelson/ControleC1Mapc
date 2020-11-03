package serviceprovider.impl;


import cloud.api.ServiceType;
import cloud.impl.base.ServiceImpl;
import serviceprovider.api.LoggingServiceType;

public final class DefaultLoggingService extends ServiceImpl implements LoggingServiceType {
    public DefaultLoggingService(String name) {
        super(name);
    }

    @Override
    public ServiceType getServiceType() {
        return this;
    }
}
