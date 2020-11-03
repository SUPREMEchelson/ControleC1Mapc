package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.Tomcat;

public interface TomcatComponentType extends ComponentType {

    String TOMCAT = "tomcat";

    @Override
    default String componentTypeKey() {return TOMCAT;}

    @Override
    default Component createComponent(String name) {
        return new Tomcat(name);
    }
}
