package cloud.impl.base;

import cloud.api.DeploymentPlan;
import cloud.api.DeploymentPlanShutdown;

public abstract class DeploymentPlanShutdownImpl implements DeploymentPlanShutdown {
    protected DeploymentPlanShutdown next;

    @Override
    public void setNext(DeploymentPlanShutdown handler) {
        this.next = handler;
    }

    @Override
    public boolean stop(DeploymentPlan plan) {
        if (next != null)
            return next.stop(plan);
        return true;
    }
}
