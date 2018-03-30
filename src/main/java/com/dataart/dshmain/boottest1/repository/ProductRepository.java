package com.dataart.dshmain.boottest1.repository;

import com.dataart.dshmain.boottest1.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    List<Product> findByName(String name);

}
