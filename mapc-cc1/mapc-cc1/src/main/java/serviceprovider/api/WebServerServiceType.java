package serviceprovider.api;

import cloud.api.Service;
import cloud.api.ServiceType;
import serviceprovider.impl.DefaultWebServerService;

public interface WebServerServiceType extends ServiceType {
    @Override
    default String serviceTypeKey(){return BasicServiceTypeNames.WEB_SERVER.getName();}

    @Override
    default Service createService(String name){return new DefaultWebServerService(name);}
}
