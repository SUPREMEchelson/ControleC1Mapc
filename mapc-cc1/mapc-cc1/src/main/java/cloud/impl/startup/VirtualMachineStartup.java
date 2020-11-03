package cloud.impl.startup;

import cloud.api.*;
import cloud.impl.base.DeploymentPlanStartupImpl;

public final class VirtualMachineStartup extends DeploymentPlanStartupImpl {
    private boolean allStarted;

    public VirtualMachineStartup(){
        allStarted = true;
    }

    @Override
    public boolean start(DeploymentPlan plan, boolean bestEffort) {
        allStarted = plan.getNodes().stream()
                .map(ComputeNode::getVMachines)
                .map(vms -> vms.stream().map(VirtualMachine::start).reduce(true, (v1, v2) -> v1 && v2))
                .reduce(allStarted, (s1, s2) -> s1 && s2);
        if (bestEffort)
            return next.start(plan, true);
        else if (!allStarted)
            return false;
        else return next.start(plan, false);
    }
}
