package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisCountPolicyTest {

    @Test
    void applyDiscount() {
        int price = 1000;
        int discountedPrice = DisCountPolicy.NONE.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(price);
    }
    @Test
    void fix_1000_discounted_price() {
        int price = 2000;
        int discountedPrice = DisCountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }
    @Test
    void over_discounted_price() {
        int price = 500;
        int discountedPrice = DisCountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}