package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import com.example.productorderservice.product.DisCountPolicy;
import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return new Order(new Product("상품1", 1000, DisCountPolicy.NONE), 2);
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
        paymentGateway.excute(totalPrice,cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
