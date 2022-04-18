package org.sparrow.tasks.three.sweets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SweetGift {
    private List<Sweet> sweets;

    public SweetGift(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public SweetGift(Sweet... sweet) {
        this.sweets = Arrays.stream(sweet).collect(Collectors.toList());
    }

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public double getWeight() {
        return sweets.stream().map(Sweet::getWeight).reduce(Double::sum).orElseThrow();
    }

    public double getPrice() {
        return sweets.stream().map(Sweet::getPrice).reduce(Double::sum).orElseThrow();
    }

    public void printAllInfo() {
        System.out.println("===Информация о всех сладостях в подарке===");
        sweets.forEach(System.out::println);
    }
}
