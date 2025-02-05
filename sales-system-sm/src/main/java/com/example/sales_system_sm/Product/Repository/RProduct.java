package com.example.sales_system_sm.Product.Repository;

import com.example.sales_system_sm.Category.Model.Category;
import com.example.sales_system_sm.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RProduct extends CrudRepository<Product, Long> {

    Optional<Product> findByNameProduct(String name);

}
