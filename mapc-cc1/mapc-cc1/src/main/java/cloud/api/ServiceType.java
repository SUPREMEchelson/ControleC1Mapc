package cloud.api;

public interface ServiceType extends NamedElement {
    String serviceTypeKey();
    Service createService(String name);
}
