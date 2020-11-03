package visitable.api;

import visitor.api.Visitor;

public interface Visitable {
    void accept(Visitor visitor);
}
