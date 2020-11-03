package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.Apache;

public interface ApacheComponentType extends ComponentType {

    String APACHE = "apache";

    @Override
    default String componentTypeKey() {return APACHE;}

    @Override
    default Component createComponent(String name) {
        return new Apache(name);
    }
}
