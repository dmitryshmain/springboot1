package com.dataart.dshmain.boottest1.startup;

import com.dataart.dshmain.boottest1.entity.Product;
import com.dataart.dshmain.boottest1.service.ProductService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitMongoCollections implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    public InitMongoCollections(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Product product = new Product(null, "Salo");
        productService.insert(product);
        productService.update(product.getId(), "Vodka");
        productService.findByName("Vodka");
    }
}
