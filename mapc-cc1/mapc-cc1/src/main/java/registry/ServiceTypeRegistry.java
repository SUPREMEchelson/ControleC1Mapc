package registry;

import cloud.api.ServiceType;

import java.util.*;

public final class ServiceTypeRegistry {

    private static final ServiceTypeRegistry INSTANCE = new ServiceTypeRegistry();
    private final Map<String, ServiceType> registry;

    private ServiceTypeRegistry(){
        registry = new HashMap<>();
    }

    public static ServiceTypeRegistry instance(){return INSTANCE;}

    public void registerServiceType(ServiceType serviceType){
        registry.put(serviceType.serviceTypeKey(), serviceType);
    }

    public Optional<ServiceType> getServiceTypeOf(String key) {
        return Optional.ofNullable(registry.get(key));
    }

    public Optional<List<ServiceType>> getServiceTypes() {
        return Optional.of(new ArrayList<>(registry.values()));
    }
 }
