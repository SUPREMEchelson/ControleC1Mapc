package cloud.impl.startup;

import cloud.api.DeploymentPlan;
import cloud.api.RunnableElement;
import cloud.impl.base.DeploymentPlanStartupImpl;

public final class ComputeNodeStartup extends DeploymentPlanStartupImpl {
    private boolean allStarted;

    public ComputeNodeStartup(){
        allStarted = true;
    }

    @Override
    public boolean start(DeploymentPlan plan, boolean bestEffort) {
        allStarted = plan.getNodes().stream().map(RunnableElement::start).reduce(allStarted, (n1, n2) -> n1 && n2);
        if (bestEffort)
            return next.start(plan, true);
        else if (!allStarted)
            return false;
        else return next.start(plan, false);
    }
}
