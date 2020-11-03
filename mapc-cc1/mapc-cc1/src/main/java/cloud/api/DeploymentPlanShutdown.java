package cloud.api;

public interface DeploymentPlanShutdown {
    void setNext(DeploymentPlanShutdown handler);
    boolean stop(DeploymentPlan plan);
}
