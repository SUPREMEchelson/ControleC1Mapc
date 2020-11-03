package cloud.impl.base;

import cloud.api.DeploymentPlanReport;

import java.util.ArrayList;
import java.util.List;

public abstract class DeploymentPlanReportImpl implements DeploymentPlanReport {
    private final List<Exception> exceptions;
    private final List<String> messages;

    public DeploymentPlanReportImpl(){
        exceptions = new ArrayList<>();
        messages = new ArrayList<>();
    }

    @Override
    public List<Exception> exceptions() {
        return this.exceptions;
    }

    @Override
    public boolean addException(Exception e) {
        if (exceptions.add(e)) {
            messages.add(e.getMessage());
        }
        return true;
    }

    @Override
    public List<String> messages() {
        return this.messages;
    }
}
