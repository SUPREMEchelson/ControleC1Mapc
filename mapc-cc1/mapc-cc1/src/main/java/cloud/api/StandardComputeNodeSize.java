package cloud.api;

public enum StandardComputeNodeSize {
    XSMALL(1, 2), SMALL(2, 4), MEDIUM(2, 8),
    MEDIUM_LARGE(4, 16), LARGE(6, 32), XLARGE(8, 64);

    private final int nbCPU;
    private final int memory;

    StandardComputeNodeSize(int nbCPU, int memory) {
        this.nbCPU = nbCPU;
        this.memory = memory;
    }

    public int getNbCPU() {
        return this.nbCPU;
    }

    public int getMemory() {
        return this.memory;
    }
}
