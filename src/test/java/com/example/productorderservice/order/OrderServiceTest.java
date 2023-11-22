package com.example.productorderservice.order;

import com.example.productorderservice.product.DisCountPolicy;
import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductService;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

//    @BeforeEach
//    void setUp() {
//        orderRepository = new OrderRepository();
//        orderPort = new OrderPort() {
//
//            @Override
//            public Product getProductById(Long productId) {
//                return new Product("상품명", 1000, DisCountPolicy.NONE);
//            }
//
//            @Override
//            public void save(Order order) {
//                orderRepository.save(order);
//            }
//        };
//        orderService = new OrderService(orderPort);
//    }

    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 상품주문요청_생성();
        orderService.createOrder(request);
    }

    private CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
