package cloud.api;

import java.util.Set;

public interface Cloud extends NamedElement {
    Set<DeploymentPlan> getPlans();
    boolean deployPlan(DeploymentPlan plan);
    boolean startPlan(DeploymentPlan plan);
    boolean stopPlan(DeploymentPlan plan);
    boolean removePlan(DeploymentPlan plan);
}
