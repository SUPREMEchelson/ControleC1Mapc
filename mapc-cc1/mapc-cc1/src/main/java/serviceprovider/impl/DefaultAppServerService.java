package serviceprovider.impl;


import cloud.api.ServiceType;
import cloud.impl.base.ServiceImpl;
import serviceprovider.api.AppServerServiceType;

public final class DefaultAppServerService extends ServiceImpl implements AppServerServiceType {
    public DefaultAppServerService(String name) {
        super(name);
    }

    @Override
    public ServiceType  getServiceType() {
        return this;
    }
}
