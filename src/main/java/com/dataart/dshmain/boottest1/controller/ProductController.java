package com.dataart.dshmain.boottest1.controller;

import com.dataart.dshmain.boottest1.entity.Product;
import com.dataart.dshmain.boottest1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(path = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path="", method=RequestMethod.GET)
    public ResponseEntity getProducts() {
         return ResponseEntity.ok().body(productService.findAll());
    }

    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public ResponseEntity getProduct(@PathVariable String id) {
        Optional<Product> product = productService.findById(id);
        return product.isPresent() ? ResponseEntity.ok().body(product) : ResponseEntity.notFound().build();
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productService.update(product);

        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(path="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "", method= RequestMethod.POST)
    public ResponseEntity create(@RequestBody Product product) {
        productService.insert(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
