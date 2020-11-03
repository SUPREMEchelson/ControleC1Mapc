package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.TomcatComponentType;

public final class Tomcat extends ComponentImpl implements TomcatComponentType {

    public Tomcat(String name) {
        super(name);
        setNbCPU(2);
        setMemory(4);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
