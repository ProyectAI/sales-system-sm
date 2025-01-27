package com.example.sales_system_sm.Category.Service;

import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Brand.Repository.RBrand;
import com.example.sales_system_sm.Category.DTO.DtoCategorySave;
import com.example.sales_system_sm.Category.Model.Category;
import com.example.sales_system_sm.Category.Repository.RCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCategory {

    @Autowired
    private RCategory r;


    //----Métodos de lógica de negocio(MLN)
    //---buscar todas las categoria-----
    public List<Category> searchCategory() {
        return r.findAll();
    }

    //----Buscar las categoria por su nombre---
    public Optional<Category> searchByName(String name) {
        return r.findByNameCategory(name);
    }

    //---Registrar una Categoría----
    public Category saveCategory(DtoCategorySave dtoCategorySave) {
        Category category = new Category(dtoCategorySave);
        category.getNameCategory();


        return r.save(category);
    }

    //----Eliminar una Categoría
    public void deletedCategory(Long id) {
        r.deleteById(id);
    }
}
