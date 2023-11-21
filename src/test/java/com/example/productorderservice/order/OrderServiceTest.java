package com.example.productorderservice.order;

import com.example.productorderservice.product.DisCountPolicy;
import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;
    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {

            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명", 1000, DisCountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    void 상품주문() {
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        orderService.createOrder(request);
    }

    private record CreateOrderRequest(Long productId, int quantity) {
        public CreateOrderRequest {
            Assert.notNull(productId,"상품 ID는 필수입니다.");
            Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        }
    }

    private class OrderService {
        private OrderPort orderPort;

        public OrderService(OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(CreateOrderRequest request) {
            final Product product = orderPort.getProductById(request.productId());

            Order order = new Order(product, request.quantity());

            orderPort.save(order);
        }
    }

    private class OrderAdapter implements OrderPort {
        private final ProductRepository productRepository;
        private OrderRepository orderRepository;

        private OrderAdapter(final ProductRepository productRepository,OrderRepository orderRepository) {
            this.productRepository = productRepository;
            this.orderRepository = orderRepository;
        }

        @Override
        public Product getProductById(final Long productId) {
            return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        }

        @Override
        public void save(Order order) {
            orderRepository.save(order);
        }
    }

    private class Order {
        private Long id;

        public Long getId() {
            return id;
        }

        public Order(final Product product, final int quantity) {
            Assert.notNull(product, "상품은 필수입니다.");
            Assert.isTrue(quantity>0, "수량은 0보다 커야 합니다.");
        }

        public void assignId(Long id) {
            this.id = id;
        }
    }
    private class OrderRepository {
        private Map<Long,Order> persistence = new HashMap<>();
        private Long sequence = 0L;
        public void save(final Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(),order);
        }
    }

    private interface OrderPort {
        Product getProductById(final Long productId);
        void save(final Order order);
    }
}
