package com.example.sales_system_sm.Product.Repository;

import com.example.sales_system_sm.Product.Model.Product;


public interface SProductImpl {

    Product findById(Long id);
    Product update(Long id, Product product);
}
