package cloud.impl.base;

import cloud.api.Cloud;
import cloud.api.DeploymentPlan;

import java.util.HashSet;
import java.util.Set;

public abstract class CloudImpl extends NamedElementImpl implements Cloud {

    private final Set<DeploymentPlan> plans;

    public CloudImpl(String name) {
        super(name);
        plans = new HashSet<>();
    }

    @Override
    public Set<DeploymentPlan> getPlans() {
        return this.plans;
    }

    @Override
    public boolean deployPlan(DeploymentPlan plan) {
        return this.plans.add(plan);
    }

    @Override
    public boolean stopPlan(DeploymentPlan plan) {
        return plan.stop();
    }

    @Override
    public boolean startPlan(DeploymentPlan plan) {
        return plan.stop();
    }

    @Override
    public boolean removePlan(DeploymentPlan plan) {
        return this.plans.remove(plan);
    }
}
