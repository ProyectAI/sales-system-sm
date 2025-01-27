package com.example.sales_system_sm.Category.Repository;

import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Category.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RCategory extends JpaRepository<Category, Long> {

    Optional<Category> findByNameCategory(String name);
}
