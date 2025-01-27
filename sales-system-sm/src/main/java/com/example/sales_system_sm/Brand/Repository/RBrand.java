package com.example.sales_system_sm.Brand.Repository;

import com.example.sales_system_sm.Brand.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RBrand extends JpaRepository<Brand, Long> {

    //-----Método personalizado para hacer una búsqueda por el nombre de la marca-----
    Optional<Brand> findByNameBrand(String name);


}
