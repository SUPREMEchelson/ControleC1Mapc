package creation.api;

import cloud.api.Service;
import cloud.api.ServiceType;

public interface ServiceCreator {
    Service createService(ServiceType type, String name);
}
