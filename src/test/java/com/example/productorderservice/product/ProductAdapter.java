package com.example.productorderservice.product;

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
