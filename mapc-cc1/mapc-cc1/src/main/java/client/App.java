package client;

import cloud.api.*;
import componentprovider.api.ApacheComponentType;
import componentprovider.api.FlumeComponentType;
import componentprovider.api.MySQLComponentType;
import creation.api.CloudProvider;
import creation.impl.CloudProviderLoader;
import serviceprovider.api.BasicServiceTypeNames;

import java.util.Iterator;

import static cloud.api.StandardComputeNodeSize.LARGE;

public final class App {

    public static void main(String[] args) {
        Iterator<CloudProvider> providers = CloudProviderLoader.providers(false);
        providers.forEachRemaining(p -> {
            System.out.println("Cloud provider: " + p.getName());
            Cloud cloud = p.createCloud("MyCloud_By_" + p.getName());
            DeploymentPlan plan = p.createDeploymentPlan("My_Plan_By_" + p.getName());

            ComputeNode node_6_32 = plan.newStandardComputeNode(LARGE, "Node_" + LARGE.getNbCPU() + "_" + LARGE.getMemory());
            VirtualMachine vm1 = plan.newVirtualMachine("VM_1");

            Service web11 = plan.newService(BasicServiceTypeNames.WEB_SERVER.getName(), "Web Service 1_1");
            Component component111 = plan.newComponent(ApacheComponentType.APACHE, "Apache_1_1_1");

            Service stor11 = plan.newService(BasicServiceTypeNames.STORAGE_SERVER.getName(), "Storage Service 1_1");
            Component component112 = plan.newComponent(MySQLComponentType.MYSQL, "MySQL_1_1_2");

            Service log11 = plan.newService(BasicServiceTypeNames.LOGGING.getName(), "Logging Service 1_1");
            Component component113 = plan.newComponent(FlumeComponentType.FLUME, "Flume_1_1_3");

            plan.attachComponentToService(component111, web11)
                    .attachComponentToService(component112, stor11)
                    .deployServiceOnVm(web11, vm1)
                    .deployServiceOnVm(stor11, vm1)
                    .deployVMonNode(vm1, node_6_32);
            System.out.println("Is " + plan.name() + " valid? -> " + plan.isValid());
            if (plan.isValid()) {
                cloud.deployPlan(plan);
                System.out.println("Deployed " + plan.name() + " on cloud " + cloud.name());
                System.out.println("Starting plan " + plan.name());
                plan.start();
            } else {
                DeploymentPlanReport report = plan.getReport();
                System.out.println("Deployment report:\n" + report.messages());
            }
        });
    }

}
