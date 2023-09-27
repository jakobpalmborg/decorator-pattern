package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GenericDiscountTest {
    @Test
    void whenSetADescriptionForANewDiscountThanGetThatSameDescription() {
        Product milk = new Product("Milk", 19.0);
        ShoppingCart myShoppingCart = new ShoppingCart(5, true);
        Discount genDiscount = new GenericDiscount(new NoDiscount(),(product, shoppingCart) -> true,(product, shoppingCart) -> 1, "generic discount");
        assertThat(genDiscount.getDescription(milk,myShoppingCart)).isEqualTo("generic discount");
    }

    @Test
    void whenArgumentForIsApplicableIsTrueGetTheDescription() {
        Product milk = new Product("Milk", 19.0);
        ShoppingCart myShoppingCart = new ShoppingCart(5, true);
        Discount genDiscount = new GenericDiscount(new NoDiscount(),((product, shoppingCart) -> product.price() < 20),(product, shoppingCart) -> 1, "generic discount");
        assertThat(genDiscount.getDescription(milk,myShoppingCart)).isEqualTo("generic discount");
    }
    @Test
    void whenArgumentForIsApplicableIsFalseThanYouGetAnEmptyStringAsTheDescription() {
        Product milk = new Product("Milk", 19.0);
        ShoppingCart myShoppingCart = new ShoppingCart(5, true);
        Discount genDiscount = new GenericDiscount(new NoDiscount(),((product, shoppingCart) -> product.price() < 18),(product, shoppingCart) -> 1, "generic discount");
        assertThat(genDiscount.getDescription(milk,myShoppingCart)).isEqualTo("");
    }

    @Test
    void whenPassArgumentForCalculateDiscountThanGetTheRightResultBack() {
        Product milk = new Product("Milk", 19.0);
        ShoppingCart myShoppingCart = new ShoppingCart(5, true);
        Discount genDiscount = new GenericDiscount(new NoDiscount(),(product, shoppingCart) -> true,(product, shoppingCart) -> product.price() * 0.5, "generic discount");
        assertThat(genDiscount.apply(milk,myShoppingCart)).isEqualTo(9.5);
    }
}
