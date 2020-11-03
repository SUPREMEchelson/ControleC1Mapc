package cloud.impl.base;

import cloud.api.RunnableElement;

public abstract class RunnableElementImpl implements RunnableElement {

    boolean isRunning;

    @Override
    public boolean start() {
        isRunning = true;
        return true;
    }

    @Override
    public boolean stop() {
        isRunning = false;
        return true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
