package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    @OneToOne
    private Order order;
    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.notNull(cardNumber, "카드번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }

}
