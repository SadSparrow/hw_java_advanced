package org.sparrow.tasks.three.sweets;

import java.util.Objects;

public class Lollipop extends AbstractSweet {
    private final String flavor;

    protected Lollipop(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Lollipop lollipop = (Lollipop) o;

        return Objects.equals(flavor, lollipop.flavor);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flavor != null ? flavor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%nLollipop {%s %nflavor: %s}", super.toString(), flavor);
    }
}
