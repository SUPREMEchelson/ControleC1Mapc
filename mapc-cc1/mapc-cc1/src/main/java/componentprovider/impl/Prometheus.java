package componentprovider.impl;

import cloud.api.ComponentType;
import cloud.impl.base.ComponentImpl;
import componentprovider.api.FlumeComponentType;
import componentprovider.api.PrometheusComponentType;

public final class Prometheus extends ComponentImpl implements PrometheusComponentType {
    public Prometheus(String name) {
        super(name);
        setNbCPU(2);
        setMemory(4);
    }

    @Override
    public ComponentType getComponentType() {
        return this;
    }
}
