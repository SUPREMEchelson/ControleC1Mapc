package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.MySQL;

public interface MySQLComponentType extends ComponentType  {
    String MYSQL = "mysql";

    @Override
    default String componentTypeKey() {return MYSQL;}

    @Override
    default Component createComponent(String name) {
        return new MySQL(name);
    }
}
