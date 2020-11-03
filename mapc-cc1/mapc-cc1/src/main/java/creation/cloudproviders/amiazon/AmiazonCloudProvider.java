package creation.cloudproviders.amiazon;

import cloud.api.Cloud;
import cloud.api.DeploymentPlan;
import cloud.impl.base.DefaultDeploymentPlan;
import creation.api.CloudProvider;

public final class AmiazonCloudProvider implements CloudProvider {

    public static final String AMIAZON = "Amiazon";

    @Override
    public Cloud createCloud(String name) {
        return new AmiazonCloud(name);
    }

    @Override
    public DeploymentPlan createDeploymentPlan(String name) {
        return AmiazonDeploymentPlanCreator.instance().createDeploymentPlan(name);
    }

    @Override
    public String getName() {
        return AMIAZON;
    }

}
