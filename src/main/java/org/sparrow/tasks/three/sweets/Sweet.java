package org.sparrow.tasks.three.sweets;

import java.util.Objects;
import java.util.UUID;

public class Sweet {
    private final String name;
    private final double weight;
    private final double price;
    private final String uuid;

    public Sweet(String name, double weight, double price) {
        Objects.requireNonNull(name);
        if (weight <= 0 || price <= 0) {
            throw new IllegalArgumentException("Цена/вес должны быть больше нуля");
        }
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uuid = UUID.randomUUID().toString();
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

        Sweet sweet = (Sweet) o;

        if (Double.compare(sweet.weight, weight) != 0) return false;
        if (Double.compare(sweet.price, price) != 0) return false;
        return name.equals(sweet.name);
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
        return String.format("{%s (uuid: %s)%nweight: %.2f, price: %.2f}", name, uuid, weight, price);
    }
}
