package cloud.impl.base;

import cloud.api.DeploymentPlanShutdown;
import cloud.api.DeploymentPlanStartup;
import cloud.impl.shutdown.*;
import cloud.impl.startup.*;

public final class DefaultDeploymentPlan extends DeploymentPlanImpl {

    private final DeploymentPlanStartup start1;
    private final DeploymentPlanStartup start2;
    private final DeploymentPlanStartup start3;
    private final DeploymentPlanStartup start4;
    private final DeploymentPlanStartup start5;
    private final DeploymentPlanStartup start6;
    private final DeploymentPlanStartup start7;

    private final DeploymentPlanShutdown stop1;
    private final DeploymentPlanShutdown stop2;
    private final DeploymentPlanShutdown stop3;
    private final DeploymentPlanShutdown stop4;
    private final DeploymentPlanShutdown stop5;
    private final DeploymentPlanShutdown stop6;
    private final DeploymentPlanShutdown stop7;

    public DefaultDeploymentPlan(String name) {
        super(name);
        start1 = new ComputeNodeStartup();
        start2 = new VirtualMachineStartup();
        start3 = new LoggingServiceStartup();
        start4 = new StorageServiceStartup();
        start5 = new ApplicationServiceStartup();
        start6 = new WebServiceStartup();
        start7 = new MonitoringServiceStartup();

        start1.setNext(start2);
        start2.setNext(start3);
        start3.setNext(start4);
        start4.setNext(start5);
        start5.setNext(start6);
        start6.setNext(start7);

        stop1 = new WebServiceShutdown();
        stop2 = new ApplicationServiceShutdown();
        stop3 = new MonitoringServiceShutdown();
        stop4 = new StorageServiceShutdown();
        stop5 = new LoggingServiceShutdown();
        stop6 = new VirtualMachineShutdown();
        stop7 = new ComputeNodeShutdown();

        stop1.setNext(stop2);
        stop2.setNext(stop3);
        stop3.setNext(stop4);
        stop4.setNext(stop5);
        stop5.setNext(stop6);
        stop6.setNext(stop7);

    }

    @Override
    public boolean start() {
        return start1.start(this, true);
    }

    @Override
    public boolean stop() {
        return stop1.stop(this);
    }

    @Override
    public boolean isRunning() {
        throw new UnsupportedOperationException("Operation not yet supported.");
    }
}
