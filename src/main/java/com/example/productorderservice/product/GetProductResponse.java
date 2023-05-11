package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(long id, String name, int price, DisCountPolicy disCountPolicy) {
    GetProductResponse(final long id, final String name, final int price, final DisCountPolicy disCountPolicy) {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(disCountPolicy, "할인 정책은 필수입니다.");
        this.id = id;
        this.name = name;
        this.price = price;
        this.disCountPolicy = disCountPolicy;
    }
}
