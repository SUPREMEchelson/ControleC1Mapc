package cloud.api;

public interface Service extends Resource, RunnableElement {

    Component getComponent();

    void setComponent(Component component);

    ServiceType getServiceType();

}
