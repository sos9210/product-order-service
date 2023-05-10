package com.example.productorderservice.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

    private ProductRepository productRepository;

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }

}
