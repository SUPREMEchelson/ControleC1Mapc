package cloud.api;

public interface RunnableElement {
    boolean start();
    boolean stop();
    boolean isRunning();
    default boolean restart() {return stop() && start();}
}
