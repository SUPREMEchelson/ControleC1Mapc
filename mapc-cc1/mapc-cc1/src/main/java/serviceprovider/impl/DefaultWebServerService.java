package serviceprovider.impl;


import cloud.api.ServiceType;
import cloud.impl.base.ServiceImpl;
import serviceprovider.api.WebServerServiceType;

public final class DefaultWebServerService extends ServiceImpl implements WebServerServiceType {
    public DefaultWebServerService(String name) {
        super(name);
    }

    @Override
    public ServiceType getServiceType() {
        return this;
    }
}
