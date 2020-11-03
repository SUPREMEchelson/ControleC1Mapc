package cloud.impl.startup;

import cloud.impl.base.ServiceStartup;
import serviceprovider.api.BasicServiceTypeNames;

public final class StorageServiceStartup extends ServiceStartup {

    public StorageServiceStartup(){
        super();
        this.setServiceTypeKey(BasicServiceTypeNames.STORAGE_SERVER.getName());
    }
}
