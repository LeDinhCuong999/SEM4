package com.example.itemdemo.model;

import com.example.itemdemo.entity.Product;

import java.util.List;

public interface ProductModel {

    Product save(Product product);

    List<Product> findAll();

    Product findById(String id);

    Product update(String id, Product updateProduct);

    boolean delete(String id);
}
