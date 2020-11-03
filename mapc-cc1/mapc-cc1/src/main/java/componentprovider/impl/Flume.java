package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.FlumeComponentType;

public final class Flume extends ComponentImpl implements FlumeComponentType {
    public Flume(String name) {
        super(name);
        setNbCPU(2);
        setMemory(4);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
