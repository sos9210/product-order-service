package com.example.productorderservice.product;

import org.springframework.util.Assert;

class Product {

    private Long id;
    private final String name;
    private final int price;
    private final DisCountPolicy disCountPolicy;

    public Product(final String name, final int price, final DisCountPolicy disCountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(disCountPolicy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.disCountPolicy = disCountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
