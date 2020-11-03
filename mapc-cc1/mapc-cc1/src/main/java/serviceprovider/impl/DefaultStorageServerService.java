package serviceprovider.impl;


import cloud.api.ServiceType;
import cloud.impl.base.ServiceImpl;
import serviceprovider.api.StorageServerServiceType;

public final class DefaultStorageServerService extends ServiceImpl implements StorageServerServiceType {
    public DefaultStorageServerService(String name) {
        super(name);
    }

    @Override
    public ServiceType getServiceType() {
        return this;
    }
}
