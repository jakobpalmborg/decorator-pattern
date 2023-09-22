package org.example;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 20.0, 1);
        Product butter = new Product("Butter", 20.0, 1);

        Discount myFirstDiscount = new MilkDiscount(new FridayDiscount(new QuantityDiscount(null)));

        System.out.println(myFirstDiscount.apply(butter));
        System.out.println(myFirstDiscount.apply(milk));

    }
}
