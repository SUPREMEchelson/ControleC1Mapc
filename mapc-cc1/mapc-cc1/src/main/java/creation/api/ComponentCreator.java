package creation.api;

import cloud.api.Component;
import cloud.api.ComponentType;

public interface ComponentCreator {
    Component createComponent(ComponentType type, String name);
}
