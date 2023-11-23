package com.example.productorderservice.payment;

import java.util.HashMap;
import java.util.Map;

class PaymentRepository {
    private Map<Long, Payment> persistence = new HashMap<>();
    private Long sequnce = 0L;

    public void save(Payment payment) {
        payment.assignId(++sequnce);
        persistence.put(payment.getId(), payment);
    }
}
