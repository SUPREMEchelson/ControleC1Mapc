package cloud.impl.shutdown;

import cloud.impl.base.ServiceShutdown;
import serviceprovider.api.BasicServiceTypeNames;

public final class StorageServiceShutdown extends ServiceShutdown {

    public StorageServiceShutdown(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.STORAGE_SERVER.getName());
    }
}
