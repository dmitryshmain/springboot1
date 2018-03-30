package com.dataart.dshmain.boottest1.service;

import com.dataart.dshmain.boottest1.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void insert(Product product);
    void update(String id, String name);
    void update(Product product);
    List<Product> findByName(String name);
    Optional<Product> findById(String id);
    List<Product> findAll();
    void delete(String id);
}
