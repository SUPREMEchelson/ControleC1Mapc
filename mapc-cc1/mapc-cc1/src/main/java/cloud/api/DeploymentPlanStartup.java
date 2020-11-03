package cloud.api;

public interface DeploymentPlanStartup {
    void setNext(DeploymentPlanStartup handler);
    boolean start(DeploymentPlan plan, boolean bestEffort);
}
