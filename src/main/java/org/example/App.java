package org.example;

public class App {
    public static void main(String[] args) {

        ShoppingCart fridayShoppingCart = new ShoppingCart(3, true);
        ShoppingCart notFridayShoppingCart = new ShoppingCart(3, false);
        ShoppingCart lessThanFiveItems = new ShoppingCart(4, false);
        ShoppingCart moreThanFiveItems = new ShoppingCart(6, false);


        Product milk = new Product("Milk", 100.0, 1);
        Product butter = new Product("Butter", 100.0, 1);

        Discount myFirstDiscount = new MilkDiscount(new FridayDiscount(new QuantityDiscount(null)));

        System.out.println(myFirstDiscount.apply(butter, fridayShoppingCart));
        System.out.println(myFirstDiscount.apply(butter, notFridayShoppingCart));

        System.out.println(myFirstDiscount.apply(milk, notFridayShoppingCart));
        System.out.println(myFirstDiscount.apply(milk, fridayShoppingCart));

        System.out.println(myFirstDiscount.apply(butter, lessThanFiveItems));
        System.out.println(myFirstDiscount.apply(butter, moreThanFiveItems));



    }
}
