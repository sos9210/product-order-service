package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
        productService.addProduct(request);
    }

    private AddProductRequest 상품등록요청_생성() {
        final String name = "상품명입니다";
        final int price = 1000;
        final DisCountPolicy disCountPolicy = DisCountPolicy.NONE;
        return new AddProductRequest(name, price, disCountPolicy);
    }

}
