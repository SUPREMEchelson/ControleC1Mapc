package cloud.impl.base;

import cloud.api.NamedElement;
import visitable.impl.VisitableImpl;

import java.util.Objects;

public abstract class NamedElementImpl extends VisitableImpl implements NamedElement {

    private final String name;

    public NamedElementImpl(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedElementImpl that = (NamedElementImpl) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NamedElementImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
