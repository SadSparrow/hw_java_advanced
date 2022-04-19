package org.sparrow.tasks.three.sweets;

public class Cake extends AbstractSweet {
    private final int calories;


    protected Cake(String name, double weight, double price, int calories) {
        super(name, weight, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cake cake = (Cake) o;

        return calories == cake.calories;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + calories;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%nCake {%s %ncalories: %d}", super.toString(), calories);
    }
}
