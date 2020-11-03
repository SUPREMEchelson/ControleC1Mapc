package io;

import java.io.IOException;
import java.util.*;

public final class ServiceDefinitionLoader {

    public static final String SERVICES_PROPERTIES = "services.properties";
    private static final ServiceDefinitionLoader LOADER = new ServiceDefinitionLoader();
    public static final String REGEX = "|";
    private final Properties properties;

    private ServiceDefinitionLoader() {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(SERVICES_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ServiceDefinitionLoader instance() {
        return LOADER;
    }

    public Set<String> serviceTypes(){
        return properties.stringPropertyNames();
    }

    public Optional<Set<String>> implementingComponentTypesOf(String serviceType) {
        String propValue = properties.getProperty(serviceType);
        if (propValue != null) {
            String[] ctypes = propValue.split(REGEX);
            return Optional.of(Set.of(ctypes));
        } else {
            return Optional.empty();
        }
    }
}
