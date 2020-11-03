package componentprovider.api;

import cloud.api.Component;
import cloud.api.ComponentType;
import componentprovider.impl.MongoDb;
import componentprovider.impl.MySQL;

public interface MongoDBComponentType extends ComponentType  {
    String MONGODB = "mongodb";

    @Override
    default String componentTypeKey() {return MONGODB;}

    @Override
    default Component createComponent(String name) {
        return new MongoDb(name);
    }
}
