package registry;

import cloud.api.ComponentType;
import cloud.api.ServiceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ComponentTypeRegistry {
    private static final ComponentTypeRegistry INSTANCE = new ComponentTypeRegistry();
    private final Map<String, ComponentType> cTypeRegistry;
    private final Map<ComponentType, ServiceType> cTypeSTypeRegistry;

    private ComponentTypeRegistry() {
        cTypeRegistry = new HashMap<>();
        cTypeSTypeRegistry = new HashMap<>();
    }

    public static ComponentTypeRegistry instance() {
        return INSTANCE;
    }

    public void registerComponentType(ComponentType componentType) {
        cTypeRegistry.put(componentType.componentTypeKey(), componentType);
    }

    public Optional<ComponentType> getComponentTypeOf(String key) {
        return Optional.ofNullable(cTypeRegistry.get(key));
    }
}
