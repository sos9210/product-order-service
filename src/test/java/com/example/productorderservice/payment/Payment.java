package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Long id;
    private String cardNumber;
    private Order order;
    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.notNull(cardNumber, "카드번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }


    public String getCardNumber() {
        return cardNumber;
    }
}
