package cloud.impl.base;

import cloud.api.*;

public abstract class ServiceImpl extends NamedElementImpl implements Service {
    private final DefaultResource resource;
    private final DefaultRunnableElement runnable;
    private Component component;

    public ServiceImpl(String name) {
        super(name);
        resource = new DefaultResource(name);
        runnable = new DefaultRunnableElement();
    }

    @Override
    public Component getComponent() {
        return this.component;
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
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
        component.start();
        System.out.println("Starting service " + this.name());
        return runnable.start();
    }

    @Override
    public boolean stop() {
        component.stop();
        System.out.println("Stopping service " + this.name());
        return runnable.stop();
    }

    @Override
    public boolean isRunning() {
        System.out.println("Running status of service " + this.name() + " " + runnable.isRunning);
        return runnable.isRunning;
    }
}
