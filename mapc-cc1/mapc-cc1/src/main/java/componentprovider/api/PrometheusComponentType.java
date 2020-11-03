package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.Flume;
import componentprovider.impl.Prometheus;

public interface PrometheusComponentType extends ComponentType {
    String PROMETHEUS = "prometheus";

    @Override
    default String componentTypeKey() {return PROMETHEUS;}

    @Override
    default Component createComponent(String name) {
        return new Prometheus(name);
    }
}
