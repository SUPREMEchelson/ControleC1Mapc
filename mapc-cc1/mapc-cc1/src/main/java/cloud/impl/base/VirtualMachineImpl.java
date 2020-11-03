package cloud.impl.base;

import cloud.api.Service;
import cloud.api.ServiceType;
import cloud.api.VirtualMachine;
import vmosprovider.api.VmOSName;

import java.util.HashSet;
import java.util.Set;

public abstract class VirtualMachineImpl extends NamedElementImpl implements VirtualMachine {

    private final DefaultResource resource;
    private final DefaultRunnableElement runnable;
    private final Set<Service> services;
    private VmOSName os;

    public VirtualMachineImpl(String name) {
        super(name);
        services = new HashSet<>();
        resource = new DefaultResource(name);
        runnable = new DefaultRunnableElement();
    }

    @Override
    public void setOS(VmOSName os) {
        this.os = os;
    }

    @Override
    public VmOSName getOS() {
        return this.os;
    }

    @Override
    public boolean addService(Service service) {
        return services.add(service);
    }

    @Override
    public boolean removeService(Service service) {
        return services.remove(service);
    }

    @Override
    public Set<Service> getServices() {
        return this.services;
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
    }

    @Override
    public void setMemory(int memory) {
        resource.setMemory(memory);
    }

    @Override
    public boolean start() {
        System.out.println("Starting vm " + this.name());
        return runnable.start();
    }

    @Override
    public boolean stop() {
        System.out.println("Stopping vm " + this.name());
        return runnable.stop();
    }

    @Override
    public boolean isRunning() {
        System.out.println("Running status of vm " + this.name() + " " + runnable.isRunning);
        return runnable.isRunning;
    }
}
