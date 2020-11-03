package cloud.impl.base;

import cloud.api.Resource;

public abstract class ResourceImpl extends NamedElementImpl implements Resource {
    private int nbCPU;
    private int memory;

    public ResourceImpl(String name) {
        super(name);
    }

    @Override
    public int getNbCPU() {
        return this.nbCPU;
    }

    @Override
    public void setNbCPU(int nbCPU) {
        this.nbCPU = nbCPU;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    @Override
    public void setMemory(int memory) {
        this.memory = memory;
    }

}
