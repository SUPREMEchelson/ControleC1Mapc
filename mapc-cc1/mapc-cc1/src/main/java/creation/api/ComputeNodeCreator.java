package creation.api;

import cloud.api.ComputeNode;

public interface ComputeNodeCreator {
    ComputeNode createComputeNode(int nbCPU, int memory, String name);
}
