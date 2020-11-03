package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.Flume;

public interface FlumeComponentType extends ComponentType {
    String FLUME = "flume";

    @Override
    default String componentTypeKey() {return FLUME;}

    @Override
    default Component createComponent(String name) {
        return new Flume(name);
    }
}
