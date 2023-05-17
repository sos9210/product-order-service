package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

//    @Autowired
//    private ProductService productService;
//
//    @Test
//    void 상품조회() {
//        //상품등록
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//        final long productId = 1L;
//
//        //상품을 조회
//        final GetProductResponse response = productService.getProduct(productId);
//
//        //상품의 응답을 검증
//        assertThat(response).isNotNull();
//    }
//
//    private AddProductRequest 상품등록요청_생성() {
//        final String name = "상품명입니다";
//        final int price = 1000;
//        final DisCountPolicy disCountPolicy = DisCountPolicy.NONE;
//        return new AddProductRequest(name, price, disCountPolicy);
//    }
    private ProductService productService;
    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }
    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DisCountPolicy.NONE);
        final Product product = new Product("상품명", 1000, DisCountPolicy.NONE);
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        productService.updateProduct(productId, request);

        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);
    }

}
