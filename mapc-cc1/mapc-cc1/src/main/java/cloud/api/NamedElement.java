package cloud.api;

import visitable.api.Visitable;

public interface NamedElement extends Visitable {
    String name();
}
