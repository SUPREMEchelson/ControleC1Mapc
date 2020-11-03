package cloud.impl.shutdown;

import cloud.api.ComputeNode;
import cloud.api.DeploymentPlan;
import cloud.api.VirtualMachine;
import cloud.impl.base.DeploymentPlanShutdownImpl;

public final class VirtualMachineShutdown extends DeploymentPlanShutdownImpl {
    private final boolean allShutdown;

    public VirtualMachineShutdown(){
        allShutdown = true;
    }

    @Override
    public boolean stop(DeploymentPlan plan) {
        return plan.getNodes().stream()
                .map(ComputeNode::getVMachines)
                .map(vms -> vms.stream().map(VirtualMachine::stop).reduce(true, (v1, v2) -> v1 && v2))
                .reduce(allShutdown, (s1, s2) -> s1 && s2);
    }
}
