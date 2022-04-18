package org.sparrow.tasks.three.sweets;

public class Main {

    public static void main(String[] args) {
        Sweet candyLindt = new Sweet("Lindt Lindor", 0.2, 639.00);
        Sweet candyVodka = new Sweet("Fazer Finlandia Vodka", 0.15, 309.00);
        Sweet chocolateMerci = new Sweet("Merci", 0.4, 899.00);
        Sweet chocolateMilka = new Sweet("Milka", 0.3, 339.0);

        SweetGift gift = new SweetGift(candyLindt, candyVodka, chocolateMilka, chocolateMerci);

        System.out.printf("Общий вес подарка: %.2f%n", gift.getWeight());
        System.out.printf("Общая стоимость подарка: %.2f%n", gift.getPrice());

        gift.printAllInfo();
    }
}
