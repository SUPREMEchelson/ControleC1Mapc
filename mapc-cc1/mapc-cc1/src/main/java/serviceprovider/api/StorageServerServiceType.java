package serviceprovider.api;

import cloud.api.Service;
import cloud.api.ServiceType;
import serviceprovider.impl.DefaultStorageServerService;

public interface StorageServerServiceType extends ServiceType {
    @Override
    default String serviceTypeKey(){return BasicServiceTypeNames.STORAGE_SERVER.getName();}

    @Override
    default Service createService(String name){return new DefaultStorageServerService(name);}
}
