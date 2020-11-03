package cloud.api;

import java.util.Optional;
import java.util.Set;

public interface DeploymentPlan extends NamedElement, RunnableElement {
    ComputeNode newStandardComputeNode(StandardComputeNodeSize size, String name);
    ComputeNode newPersonalizedComputeNode(int nbCPU, int memory, String name);
    VirtualMachine newVirtualMachine(String name);
    Service newService(String key, String name);
    Component newComponent(String key, String name);
    Set<ComputeNode> getNodes();
    Optional<ComputeNode> getNode(String name);
    DeploymentPlan deployVMonNode(VirtualMachine vm, ComputeNode node);
    DeploymentPlan deployServiceOnVm(Service service, VirtualMachine vm);
    DeploymentPlan attachComponentToService(Component component, Service service);
    boolean isValid();
    DeploymentPlanReport getReport();
}
