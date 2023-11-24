package com.example.productorderservice.payment;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.product.ProductSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class PaymentApiTest extends ApiTest {


    @Test
    void 주문결제() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        var request = PaymentSteps.주문결제요청_생성();

        var response = PaymentSteps.주문결제요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
