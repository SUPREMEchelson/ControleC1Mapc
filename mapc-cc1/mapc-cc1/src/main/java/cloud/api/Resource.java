package cloud.api;

public interface Resource extends NamedElement {
        int getNbCPU();
        int getMemory();
        void setNbCPU(int nbCPU);
        void setMemory(int memory);
}
