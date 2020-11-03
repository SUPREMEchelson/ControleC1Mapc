package cloud.impl.base;

import cloud.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ServiceStartup extends DeploymentPlanStartupImpl {
    private boolean allStarted;
    private String serviceTypeKey;

    public ServiceStartup(){
        allStarted = true;
    }

    public void setServiceTypeKey(String serviceTypeKey) {
        this.serviceTypeKey = serviceTypeKey;
    }

    @Override
    public boolean start(DeploymentPlan plan, boolean bestEffort){
        plan.getNodes().forEach(n->{
            List<Service> loggingServices =  n.getVMachines().stream()
                    .map(VirtualMachine::getServices)
                    .map(services -> services.stream().filter(s ->
                            s.getServiceType().serviceTypeKey().equals(serviceTypeKey)
                    )).reduce(Stream::concat).orElseGet(Stream::empty).collect(Collectors.toList());
            allStarted &= loggingServices.stream().map(RunnableElement::start).reduce(true, (s1, s2) -> s1 && s2);
        });
        if (bestEffort)
            return continueStartupProcess(plan, true);
        else if (!allStarted)
            return false;
        else return continueStartupProcess(plan, false);
    }

    private boolean continueStartupProcess(DeploymentPlan plan, boolean bestEffort) {
        return next == null || next.start(plan, bestEffort);
    }
}
