package cloud.impl.base;

import cloud.api.ComputeNode;
import cloud.api.VirtualMachine;
import exception.ResourceAlreadyExistsException;

import javax.naming.InsufficientResourcesException;
import java.util.HashSet;
import java.util.Set;

public abstract class ComputeNodeImpl extends NamedElementImpl implements ComputeNode {

    private final DefaultResource resource;
    private final DefaultRunnableElement runnable;
    private final Set<VirtualMachine> vmachines;
    private int remainingCPU;
    private int remainingMemory;

    public ComputeNodeImpl(String name) {
        super(name);
        vmachines = new HashSet<>();
        resource = new DefaultResource(name);
        runnable = new DefaultRunnableElement();
    }

    @Override
    public boolean addVMachine(VirtualMachine machine) throws InsufficientResourcesException, ResourceAlreadyExistsException {
        if (remainingCPU - machine.getNbCPU() < 0 || remainingMemory - machine.getMemory() < 0) {
            throw new InsufficientResourcesException("Node " + this.name()
                    + " does not have enough resources for machine " + machine.name());
        }
        if (vmachines.add(machine)) {
            remainingCPU -= machine.getNbCPU();
            remainingMemory -= machine.getMemory();
        } else {
            throw new ResourceAlreadyExistsException("Virtual machine " + machine.name()
                    + " already deployed on node " + this.name());
        }
        return true;
    }

    @Override
    public boolean removeVMachine(VirtualMachine machine) {
        return vmachines.remove(machine);
    }

    @Override
    public Set<VirtualMachine> getVMachines() {
        return vmachines;
    }

    @Override
    public boolean shutDownVMachine(VirtualMachine machine) {
        return vmachines.contains(machine) && machine.stop();
    }

    @Override
    public boolean startVirtualMachine(VirtualMachine machine) {
        return vmachines.contains(machine) && machine.start();
    }

    @Override
    public int getNbCPU() {
        return resource.getNbCPU();
    }

    @Override
    public int getMemory() {
        return resource.getMemory();
    }

    @Override
    public void setNbCPU(int nbCPU) {
        resource.setNbCPU(nbCPU);
        remainingCPU = nbCPU;
    }

    @Override
    public void setMemory(int memory) {
        resource.setMemory(memory);
        remainingMemory = memory;
    }

    @Override
    public boolean start() {
        System.out.println("Starting node " + this.name());
        return runnable.start();
    }

    @Override
    public boolean stop() {
        System.out.println("Stopping node " + this.name());
        return runnable.stop();
    }

    @Override
    public boolean isRunning() {
        System.out.println("Running status of node " + this.name() + " " + runnable.isRunning);
        return runnable.isRunning;
    }

}
