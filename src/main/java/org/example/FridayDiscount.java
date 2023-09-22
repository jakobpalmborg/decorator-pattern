package org.example;

public class FridayDiscount extends BaseDiscount {


    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product, ShoppingCart shoppingCart) {
        return shoppingCart.isFriday();
    }

    @Override
    protected double calculateDiscount(Product product, ShoppingCart shoppingCart) {
        if (isApplicable(product, shoppingCart)) return product.getPrice() * 0.1;
        else return 0;
    }

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        return calculateDiscount(product, shoppingCart) + nextDiscount.apply(product, shoppingCart);
    }

    @Override
    public String getDescription(Product product) {
        return "Friday discount, " + nextDiscount.getDescription(product);
    }
}
