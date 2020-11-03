package creation.api;

import cloud.api.Cloud;
import cloud.api.DeploymentPlan;

public interface CloudProvider {
    String getName();
    Cloud createCloud(String name);
    DeploymentPlan createDeploymentPlan(String name);
}
