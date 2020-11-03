package creation.impl;

import creation.api.CloudProvider;

import java.util.Iterator;
import java.util.ServiceLoader;

public final class CloudProviderLoader {
    private static final ServiceLoader<CloudProvider> LOADER = ServiceLoader.load(CloudProvider.class);

    private CloudProviderLoader(){}

    public static Iterator<CloudProvider> providers(boolean refresh) {
        if (refresh)
            LOADER.reload();
        return LOADER.iterator();
    }

}
