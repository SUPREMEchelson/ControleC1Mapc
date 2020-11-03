package cloud.api;

import exception.ResourceAlreadyExistsException;

import javax.naming.InsufficientResourcesException;
import java.util.Set;

public interface ComputeNode extends Resource, RunnableElement {
    boolean addVMachine(VirtualMachine machine) throws InsufficientResourcesException, ResourceAlreadyExistsException;
    boolean removeVMachine(VirtualMachine machine);
    Set<VirtualMachine> getVMachines();
    boolean shutDownVMachine(VirtualMachine machine);
    boolean startVirtualMachine(VirtualMachine machine);
}
