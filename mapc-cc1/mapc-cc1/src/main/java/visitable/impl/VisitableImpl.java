package visitable.impl;

import visitable.api.Visitable;
import visitor.api.Visitor;

public abstract class VisitableImpl implements Visitable {
    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
