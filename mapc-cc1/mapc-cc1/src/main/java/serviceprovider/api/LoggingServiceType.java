package serviceprovider.api;

import cloud.api.Service;
import cloud.api.ServiceType;
import serviceprovider.impl.DefaultLoggingService;

public interface LoggingServiceType extends ServiceType {
    @Override
    default String serviceTypeKey(){return BasicServiceTypeNames.LOGGING.getName();}

    @Override
    default Service createService(String name){return new DefaultLoggingService(name);}
}
