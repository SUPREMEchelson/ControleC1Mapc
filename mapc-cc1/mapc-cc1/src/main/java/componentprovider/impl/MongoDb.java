package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.MongoDBComponentType;
import componentprovider.api.MySQLComponentType;

public final class MongoDb extends ComponentImpl implements MongoDBComponentType {
    public MongoDb(String name) {
        super(name);
        setNbCPU(1);
        setMemory(2);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
