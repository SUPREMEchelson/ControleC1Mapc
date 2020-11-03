package creation.cloudproviders.amiazon;

import cloud.api.DeploymentPlan;
import cloud.impl.base.DefaultDeploymentPlan;
import componentprovider.impl.*;
import creation.api.DeploymentPlanCreator;
import registry.ComponentTypeRegistry;
import registry.ServiceTypeRegistry;
import serviceprovider.impl.*;

public final class AmiazonDeploymentPlanCreator implements DeploymentPlanCreator {

    private static final AmiazonDeploymentPlanCreator INSTANCE = new AmiazonDeploymentPlanCreator();
    public static final String DEFAULT_APACHE = "Default Apache";
    private static final String DEFAULT_NGINX = "Default Nginx";
    private static final String DEFAULT_TOMCAT = "Defaut Tomcat";
    private static final String DEFAULT_MYSQL = "Default MySQL";
    private static final String DEFAULT_MONGODB = "Default MongoDb";
    private static final String DEFAULT_FLUME = "Default Flume";
    private static final String DEFAULT_PROMETHEUS = "Default Prometheus";
    public static final String DEFAULT_WEB_SERVER_SERVICE = "Default Web Server Service";
    public static final String DEFAULT_APP_SERVER_SERVICE = "Default App Server Service";
    public static final String DEFAULT_STORAGE_SERVER_SERVICE = "Default Storage Server Service";
    public static final String DEFAULT_LOGGING_SERVER_SERVICE = "Default Logging Server Service";
    public static final String DEFAULT_MONITORING_SERVER_SERVICE = "Default Monitoring Server Service";

    private AmiazonDeploymentPlanCreator(){
        ComponentTypeRegistry ctRegistry = ComponentTypeRegistry.instance();
        ctRegistry.registerComponentType(new Apache(DEFAULT_APACHE));
        ctRegistry.registerComponentType(new Nginx(DEFAULT_NGINX));
        ctRegistry.registerComponentType(new Tomcat(DEFAULT_TOMCAT));
        ctRegistry.registerComponentType(new MySQL(DEFAULT_MYSQL));
        ctRegistry.registerComponentType(new MongoDb(DEFAULT_MONGODB));
        ctRegistry.registerComponentType(new Flume(DEFAULT_FLUME));
        ctRegistry.registerComponentType(new Prometheus(DEFAULT_PROMETHEUS));

        ServiceTypeRegistry sRegistry = ServiceTypeRegistry.instance();
        sRegistry.registerServiceType(new DefaultWebServerService(DEFAULT_WEB_SERVER_SERVICE));
        sRegistry.registerServiceType(new DefaultAppServerService(DEFAULT_APP_SERVER_SERVICE));
        sRegistry.registerServiceType(new DefaultStorageServerService(DEFAULT_STORAGE_SERVER_SERVICE));
        sRegistry.registerServiceType(new DefaultLoggingService(DEFAULT_LOGGING_SERVER_SERVICE));
        sRegistry.registerServiceType(new DefaultMonitoringService(DEFAULT_MONITORING_SERVER_SERVICE));
    }

    public static AmiazonDeploymentPlanCreator instance(){
        return INSTANCE;
    }

    @Override
    public DeploymentPlan createDeploymentPlan(String name) {
        return new DefaultDeploymentPlan(name);
    }
}
