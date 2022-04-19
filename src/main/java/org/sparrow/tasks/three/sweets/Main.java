package org.sparrow.tasks.three.sweets;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Lollipop lollipop1 = new Lollipop("lollipop1", 0.2, 63.0, "mint");
        Lollipop lollipop2 = new Lollipop("lollipop2", 0.3, 53.0, "apple");
        Chocolate chocolate = new Chocolate("chocolate", 0.4, 899.0, "UK");
        Cake cake1 = new Cake("cake1", 1.1, 1209.99, 675);
        Cake cake2 = new Cake("cake2", 0.8, 1509.99, 525);
        AbstractSweet[] sweets = {lollipop1, lollipop2, chocolate, cake1, cake2};

        System.out.printf("Общий вес подарка: %,.2f%n",
                Arrays.stream(sweets).map(AbstractSweet::getWeight).reduce(Double::sum).orElseThrow());

        System.out.printf("Общая стоимость подарка: %,.2f%n",
                Arrays.stream(sweets).map(AbstractSweet::getPrice).reduce(Double::sum).orElseThrow());

        System.out.println("Общая информация о подарке:");
        System.out.println(Arrays.toString(sweets));
    }
}
