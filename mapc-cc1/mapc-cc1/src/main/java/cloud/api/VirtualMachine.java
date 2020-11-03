package cloud.api;

import vmosprovider.api.VmOSName;

import java.util.Set;

public interface VirtualMachine extends Resource, RunnableElement {

    void setOS(VmOSName os);

    VmOSName getOS();

    boolean addService(Service service);

    boolean removeService(Service service);

    Set<Service> getServices();
}
