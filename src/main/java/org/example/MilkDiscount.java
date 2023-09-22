package org.example;

public class MilkDiscount extends BaseDiscount {


    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product, ShoppingCart shoppingCart) {
        return product.getName().equals("Milk");
    }

    @Override
    protected double calculateDiscount(Product product, ShoppingCart shoppingCart) {
        if (isApplicable(product, shoppingCart)) return product.getPrice() * 0.05;
        else return 0;
    }

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        return calculateDiscount(product, shoppingCart) + nextDiscount.apply(product, shoppingCart);
    }

    @Override
    public String getDescription(Product product) {
        return "Milk discount, " + nextDiscount.getDescription(product);
    }
}
