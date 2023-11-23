package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DisCountPolicy.NONE);

        product.update("상품 수정", 2000 , DisCountPolicy.NONE);

        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);
    }
    @Test
    void none_discounted_product() {
        final Product product = new Product("상품명", 1000, DisCountPolicy.NONE);

        int disCountPrice = product.getDisCountPrice();

        Assertions.assertThat(disCountPrice).isEqualTo(1000);
    }
    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("상품명", 1000, DisCountPolicy.NONE);

        int disCountPrice = product.getDisCountPrice();

        Assertions.assertThat(disCountPrice).isEqualTo(1000);
    }
}