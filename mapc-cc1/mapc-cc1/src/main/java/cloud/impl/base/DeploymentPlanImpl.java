package cloud.impl.base;

import cloud.api.*;
import exception.ResourceAlreadyExistsException;
import registry.ComponentTypeRegistry;
import registry.ServiceTypeRegistry;

import javax.naming.InsufficientResourcesException;
import java.util.*;

public abstract class DeploymentPlanImpl extends NamedElementImpl implements DeploymentPlan {

    private final DeploymentPlanReport report;
    private final Map<String, ComputeNode> nodeMap;

    public DeploymentPlanImpl(String name) {
        super(name);
        nodeMap = new HashMap<>();
        report = new DefaultDeploymentPlanReport();
    }

    @Override
    public ComputeNode newStandardComputeNode(StandardComputeNodeSize size, String name) {
        ComputeNode node = new DefaultComputeNode(name);
        node.setNbCPU(size.getNbCPU());
        node.setMemory(size.getMemory());
        ComputeNode existing = nodeMap.putIfAbsent(name, node);
        checkExistingResource(existing);
        return node;
    }

    @Override
    public ComputeNode newPersonalizedComputeNode(int nbCPU, int memory, String name) {
        ComputeNode node = new DefaultComputeNode(name);
        node.setNbCPU(nbCPU);
        node.setMemory(memory);
        ComputeNode existing = nodeMap.putIfAbsent(name, node);
        checkExistingResource(existing);
        return node;
    }

    @Override
    public VirtualMachine newVirtualMachine(String name) {
        return new DefaultVirtualMachine(name);
    }

    @Override
    public Service newService(String key, String name) {
        Optional<ServiceType> serviceType = ServiceTypeRegistry.instance().getServiceTypeOf(key);
        if (serviceType.isPresent()) {
            return serviceType.get().createService(name);
        } else {
            report.addException(new NoSuchElementException("Requested service type "
                    + key + " is not registered."));
            return null;
        }
    }

    @Override
    public Component newComponent(String key, String name) {
        Optional<ComponentType> componentType = ComponentTypeRegistry.instance().getComponentTypeOf(key);
        if (componentType.isPresent()) {
            return componentType.get().createComponent(name);
        } else {
            report.addException(new NoSuchElementException("Requested component type "
                    + key + " is not registered."));
            return null;
        }
    }

    @Override
    public Set<ComputeNode> getNodes() {
        return new HashSet<>(this.nodeMap.values());
    }

    @Override
    public Optional<ComputeNode> getNode(String name) {
        return Optional.ofNullable(this.nodeMap.get(name));
    }

    @Override
    public DeploymentPlan deployVMonNode(VirtualMachine vm, ComputeNode node) {
        try {
             node.addVMachine(vm);
        } catch (InsufficientResourcesException  | ResourceAlreadyExistsException e) {
            report.addException(e);
        }
        return this;
    }

    @Override
    public DeploymentPlan deployServiceOnVm(Service service, VirtualMachine vm) {
        if (!vm.addService(service)) {
            report.addException(new ResourceAlreadyExistsException("Service " + service.name()
                + " already exists on VM " + vm.name()));
        }
        return this;
    }

    @Override
    public DeploymentPlan attachComponentToService(Component component, Service service) {
        service.setComponent(component);
        return this;
    }

    @Override
    public boolean isValid() {
        return report.exceptions().isEmpty();
    }

    @Override
    public DeploymentPlanReport getReport() {
        return report;
    }


    private void checkExistingResource(Resource resource){
        if (resource != null)
            report.addException(new ResourceAlreadyExistsException("Compute node " + resource.name()
                    + " already in deployment plan " + this.name()));
    }
}
