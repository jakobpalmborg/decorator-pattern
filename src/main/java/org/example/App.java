package org.example;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 19.0, 1);
        Product butter = new Product("Butter", 70.0, 1);

        // Friday Discount
        ShoppingCart fridayShoppingCart = new ShoppingCart(6, true);
        ShoppingCart notFridayShoppingCart = new ShoppingCart(3, false);
        Discount fridayDiscount = new FridayDiscount(new NoDiscount());
        System.out.println("Friday true: " + fridayDiscount.getDescription(butter,fridayShoppingCart));
        System.out.println("Friday false: " + fridayDiscount.getDescription(butter,notFridayShoppingCart));
        System.out.println("Friday true: " + fridayDiscount.apply(butter, fridayShoppingCart));
        System.out.println("Friday false: " + fridayDiscount.apply(butter, notFridayShoppingCart));

        // Milk Discount
        Discount milkDiscount = new MilkDiscount(new NoDiscount());
        System.out.println("Milk discount with milk: " + milkDiscount.getDescription(milk,fridayShoppingCart));
        System.out.println("Milk discount with butter: " + milkDiscount.getDescription(butter,fridayShoppingCart));
        System.out.println("Milk discount with milk: " + milkDiscount.apply(milk,fridayShoppingCart));
        System.out.println("Milk discount with butter: " + milkDiscount.apply(butter,fridayShoppingCart));

        // Quantity Discount
        ShoppingCart lessThanFiveItems = new ShoppingCart(4, false);
        ShoppingCart moreThanFiveItems = new ShoppingCart(6, false);
        Discount quantityDiscount = new QuantityDiscount(new NoDiscount());
        System.out.println("Quantity more than 5: " + quantityDiscount.getDescription(milk, moreThanFiveItems));
        System.out.println("Quantity less than 5: " + quantityDiscount.getDescription(milk, lessThanFiveItems));
        System.out.println("Quantity more than 5: " + quantityDiscount.apply(butter, moreThanFiveItems));
        System.out.println("Quantity less than 5: " + quantityDiscount.apply(butter, lessThanFiveItems));

        // All discounts
        Discount allDiscounts = new MilkDiscount(new FridayDiscount(new QuantityDiscount(new NoDiscount())));
        System.out.println("alldiscounts: " + allDiscounts.getDescription(milk,fridayShoppingCart));
        System.out.println("alldiscounts no milk: " + allDiscounts.getDescription(butter,fridayShoppingCart));
        System.out.println("butter, friday true, more than 5: " + allDiscounts.apply(butter, fridayShoppingCart));
        System.out.println("butter, friday false, less than 5, " + allDiscounts.apply(butter, notFridayShoppingCart));
        System.out.println("milk, friday false, less than 5: " + allDiscounts.apply(milk, notFridayShoppingCart));
        System.out.println("milk, friday true, more than 5: " +  allDiscounts.apply(milk, fridayShoppingCart));
        System.out.println("butter, friday false, less than 5: " + allDiscounts.apply(butter, lessThanFiveItems));
        System.out.println("butter, friday false, more than 5: " + allDiscounts.apply(butter, moreThanFiveItems));

    }
}
