package org.example;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 20.0, 1);
        Product butter = new Product("Butter", 100.0, 1);

        // Friday Discount
        ShoppingCart fridayShoppingCart = new ShoppingCart(3, true);
        ShoppingCart notFridayShoppingCart = new ShoppingCart(3, false);
        Discount fridayDiscount = new FridayDiscount(new NoDiscount());
        System.out.println(fridayDiscount.getDescription(butter));
        System.out.println(fridayDiscount.apply(butter, fridayShoppingCart));
        System.out.println(fridayDiscount.apply(butter, notFridayShoppingCart));

        // Milk Discount
        Discount milkDiscount = new MilkDiscount(new NoDiscount());
        System.out.println(milkDiscount.getDescription(milk));
        System.out.println(milkDiscount.apply(milk,fridayShoppingCart));
        System.out.println(milkDiscount.apply(butter,fridayShoppingCart));

        // Quantity Discount
        ShoppingCart lessThanFiveItems = new ShoppingCart(4, false);
        ShoppingCart moreThanFiveItems = new ShoppingCart(6, false);
        Discount quantityDiscount = new QuantityDiscount(new NoDiscount());
        System.out.println(quantityDiscount.getDescription(milk));
        System.out.println(quantityDiscount.apply(butter, lessThanFiveItems));
        System.out.println(quantityDiscount.apply(butter, moreThanFiveItems));

        // All discounts
        Discount allDiscounts = new MilkDiscount(new FridayDiscount(new QuantityDiscount(new NoDiscount())));
        System.out.println(allDiscounts.getDescription(butter));
        System.out.println(allDiscounts.apply(butter, fridayShoppingCart));
        System.out.println(allDiscounts.apply(butter, notFridayShoppingCart));
        System.out.println(allDiscounts.apply(milk, notFridayShoppingCart));
        System.out.println(allDiscounts.apply(milk, fridayShoppingCart));
        System.out.println(allDiscounts.apply(butter, lessThanFiveItems));
        System.out.println(allDiscounts.apply(butter, moreThanFiveItems));

    }
}
