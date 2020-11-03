package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.NginxComponentType;

public final class Nginx extends ComponentImpl implements NginxComponentType {

    public Nginx(String name) {
        super(name);
        setNbCPU(1);
        setMemory(2);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
