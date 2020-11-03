package cloud.api;

import java.util.List;

public interface DeploymentPlanReport {

    List<Exception> exceptions();

    boolean addException(Exception e);

    List<String> messages();
}
