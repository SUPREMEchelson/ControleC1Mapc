package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.ApacheComponentType;

public final class Apache extends ComponentImpl implements ApacheComponentType {

    public Apache(String name) {
        super(name);
        setNbCPU(1);
        setMemory(2);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
