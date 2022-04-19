package org.sparrow.tasks.three.sweets;

import java.util.Objects;

public abstract class AbstractSweet {
    protected final String name;
    protected final double weight;
    protected final double price;

    protected AbstractSweet(String name, double weight, double price) {
        Objects.requireNonNull(name);
        if (weight <= 0 || price <= 0) {
            throw new IllegalArgumentException("Цена/вес должны быть больше нуля");
        }
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSweet that = (AbstractSweet) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.price, price) != 0) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("name: %s%nweight: %.2f, price: %.2f", name, weight, price);
    }
}
