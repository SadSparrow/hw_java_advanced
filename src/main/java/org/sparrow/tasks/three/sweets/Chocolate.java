package org.sparrow.tasks.three.sweets;

public class Chocolate extends AbstractSweet {
    private final String country;

    protected Chocolate(String name, double weight, double price, String country) {
        super(name, weight, price);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chocolate chocolate = (Chocolate) o;

        return country.equals(chocolate.country);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%nChocolate {%s %ncountry: %s}", super.toString(), country);
    }
}
