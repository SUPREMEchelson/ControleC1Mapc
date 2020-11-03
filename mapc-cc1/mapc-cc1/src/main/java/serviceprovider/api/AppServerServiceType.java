package serviceprovider.api;

import cloud.api.Service;
import cloud.api.ServiceType;
import serviceprovider.impl.DefaultAppServerService;

public interface AppServerServiceType extends ServiceType {
    @Override
    default String serviceTypeKey(){return BasicServiceTypeNames.APP_SERVER.getName();}

    @Override
    default Service createService(String name){return new DefaultAppServerService(name);}

}
