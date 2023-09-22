package org.example;

public class MilkDiscount extends BaseDiscount{


    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getName().equals("Milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        if (isApplicable(product)) return product.getPrice() * 0.05;
        else return 0;
    }

    @Override
    public double apply(Product product) {
        if (nextDiscount == null) {
            return calculateDiscount(product);
        } else {
            return calculateDiscount(product) + nextDiscount.apply(product);
        }
    }

    @Override
    public String getDescription(Product product) {
        return "Milk discount";
    }

    @Override
    public String toString() {
        return "MilkDiscount{" +
                "nextDiscount=" + nextDiscount +
                '}';
    }
}
