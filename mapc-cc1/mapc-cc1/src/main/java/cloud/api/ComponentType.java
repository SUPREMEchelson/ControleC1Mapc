package cloud.api;

public interface ComponentType extends Resource {
    String componentTypeKey();
    Component createComponent(String name);
}
