package cloud.api;

public interface Component extends Resource, RunnableElement{
    ComponentType getComponentType();
}
