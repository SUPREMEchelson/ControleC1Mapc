package visitor.api;

import visitable.api.Visitable;

public interface Visitor {
    void visit(Visitable visitable);
}
