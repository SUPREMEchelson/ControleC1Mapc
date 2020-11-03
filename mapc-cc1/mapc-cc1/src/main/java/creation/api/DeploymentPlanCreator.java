package creation.api;

import cloud.api.DeploymentPlan;

public interface DeploymentPlanCreator {
    DeploymentPlan createDeploymentPlan(String name);
}
