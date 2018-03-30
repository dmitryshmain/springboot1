package com.dataart.dshmain.boottest1.service.impl;

import com.dataart.dshmain.boottest1.entity.Product;
import com.dataart.dshmain.boottest1.repository.ProductRepository;
import com.dataart.dshmain.boottest1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class DefaultProductService implements ProductService {

    private MongoOperations ops;

    private ProductRepository productRepository;

    public DefaultProductService(MongoOperations ops, ProductRepository productRepository) {
        this.ops = ops;
        this.productRepository = productRepository;
    }

    @Override
    public void insert(Product product) {
        ops.insert(product);
        log.info("Inserted product: " + ops.findOne(new Query(where("id").is(product.getId())), Product.class));
    }

    @Override
    public void update(String id, String name) {
        Product product = ops.findById(id, Product.class);
        product.setName(name);
        ops.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        log.info("Found products by name '{}': {}", name, products.size());
        return products;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        log.info("Found products: {}", products.size());
        return products;
    }

    @Override
    public Optional<Product> findById(String id) {
        Optional<Product> product = productRepository.findById(id);

        log.info(product.isPresent() ? "Found product: " + product : "No product with id: " + id);
        return product;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
