package cloud.impl.base;

import cloud.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ServiceShutdown extends DeploymentPlanShutdownImpl {
    private boolean allShutdown;
    private String serviceTypeKey;

    public ServiceShutdown(){
        allShutdown = true;
    }

    public String getServiceTypeKey() {
        return serviceTypeKey;
    }

    public void setServiceTypeKey(String serviceTypeKey) {
        this.serviceTypeKey = serviceTypeKey;
    }

    @Override
    public boolean stop(DeploymentPlan plan){
        plan.getNodes().forEach(n->{
            List<Service> loggingServices =  n.getVMachines().stream()
                    .map(VirtualMachine::getServices)
                    .map(services -> services.stream().filter(s ->
                            s.getServiceType().serviceTypeKey().equals(serviceTypeKey)
                    )).reduce(Stream::concat).orElseGet(Stream::empty).collect(Collectors.toList());
            allShutdown &= loggingServices.stream().map(RunnableElement::stop).reduce(true, (s1, s2) -> s1 && s2);
        });
        return allShutdown;
    }
}
