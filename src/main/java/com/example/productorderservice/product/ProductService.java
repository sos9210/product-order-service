package com.example.productorderservice.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/products")
class ProductService {
    private ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody  final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.disCountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        final Product product = productPort.getProduct(productId);
        final GetProductResponse response =
                new GetProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDisCountPolicy());
        return ResponseEntity.ok(response);
    }

    public void updateProduct(Long productId, final UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);

        product.update(request.name(),request.price(),request.disCountPolicy());

        productPort.save(product);
    }
}
