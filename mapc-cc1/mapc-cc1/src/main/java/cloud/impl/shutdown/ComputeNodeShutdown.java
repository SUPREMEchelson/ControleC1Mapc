package cloud.impl.shutdown;

import cloud.api.DeploymentPlan;
import cloud.api.RunnableElement;
import cloud.impl.base.DeploymentPlanShutdownImpl;

public final class ComputeNodeShutdown extends DeploymentPlanShutdownImpl {
    private final boolean allShutdown;

    public ComputeNodeShutdown(){
        allShutdown = true;
    }

    @Override
    public boolean stop(DeploymentPlan plan) {
        return plan.getNodes().stream().map(RunnableElement::stop).reduce(allShutdown, (n1, n2) -> n1 && n2);
    }
}
