package cloud.impl.base;

import cloud.api.Component;

public abstract class ComponentImpl extends NamedElementImpl implements Component {

    private DefaultRunnableElement runnable;
    private DefaultResource resource;

    public ComponentImpl(String name) {
        super(name);
        runnable = new DefaultRunnableElement();
        resource = new DefaultResource(name);
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
        System.out.println("Starting component " + this.name());
        return runnable.start();
    }

    @Override
    public boolean stop() {
        System.out.println("Stopping component " + this.name());
        return runnable.stop();
    }

    @Override
    public boolean isRunning() {
        System.out.println("Running status of component " + this.name() + " " + runnable.isRunning);
        return runnable.isRunning;
    }
}
