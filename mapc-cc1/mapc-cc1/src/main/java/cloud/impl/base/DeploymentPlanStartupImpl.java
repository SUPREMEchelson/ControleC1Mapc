package cloud.impl.base;

import cloud.api.DeploymentPlan;
import cloud.api.DeploymentPlanStartup;

public abstract class DeploymentPlanStartupImpl implements DeploymentPlanStartup {
    protected DeploymentPlanStartup next;

    @Override
    public void setNext(DeploymentPlanStartup handler) {
        this.next = handler;
    }

    @Override
    public boolean start(DeploymentPlan plan, boolean bestEffort) {
        if (next != null)
            return next.start(plan, bestEffort);
        return true;
    }
}
