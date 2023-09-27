package org.example;

public class GenericDiscount implements Discount {
    private final Discount nextDiscount;
    private final IsApplicable isApplicable;
    private final CalculateDiscount calculateDiscount;
    private final String description;

    public GenericDiscount(Discount nextDiscount, IsApplicable isApplicable, CalculateDiscount calculateDiscount, String description) {
        this.nextDiscount = nextDiscount;
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
        this.description = description;
    }

    @Override
    public double apply(Product product, ShoppingCart shoppingCart) {
        return calculateDiscount(product, shoppingCart);
    }

    @Override
    public String getDescription(Product product, ShoppingCart shoppingCart) {
        if (isApplicable.isApplicable(product, shoppingCart))
            return nextDiscount.getDescription(product, shoppingCart) + description;
        else return nextDiscount.getDescription(product, shoppingCart);
    }

    public double calculateDiscount(Product product, ShoppingCart shoppingCart) {
        if (isApplicable.isApplicable(product, shoppingCart))
            return (nextDiscount.apply(product, shoppingCart) + calculateDiscount.calculateDiscount(product, shoppingCart));
        else return nextDiscount.apply(product, shoppingCart);
    }
}
