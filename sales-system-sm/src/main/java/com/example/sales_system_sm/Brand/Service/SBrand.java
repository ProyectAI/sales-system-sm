package com.example.sales_system_sm.Brand.Service;


import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Brand.Repository.RBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SBrand {

    @Autowired
    private RBrand r;


    //----Métodos de lógica de negocio(MLN)
    //---buscar todas las marcas-----
    public List<Brand> searchBrand() {
        return r.findAll();
    }

    //----Buscar las marcas por su nombre---
    public Optional<Brand> searchByName(String name) {
        return r.findByNameBrand(name);
    }

    //---Registrar una marca----
    public Brand saveBrand(DtoBrandSave dtoBrandSave) {
        Brand brand = new Brand(dtoBrandSave);
        brand.getNameBrand();

        return r.save(brand);
    }

    //----Eliminar una marca
    public void deletedBrand(Long id) {
        r.deleteById(id);
    }
}