package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.Nginx;

public interface NginxComponentType extends ComponentType {

    String NGINX = "nginx";

    @Override
    default String componentTypeKey() {return NGINX;}

    @Override
    default Component createComponent(String name) {
        return new Nginx(name);
    }
}
