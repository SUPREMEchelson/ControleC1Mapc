package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.MySQLComponentType;

public final class MySQL extends ComponentImpl implements MySQLComponentType {
    public MySQL(String name) {
        super(name);
        setNbCPU(1);
        setMemory(2);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
