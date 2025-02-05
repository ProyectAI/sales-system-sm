package com.example.sales_system_sm.Product.Service;


import com.example.sales_system_sm.Product.DTO.DtoProductSave;
import com.example.sales_system_sm.Product.Model.Product;
import com.example.sales_system_sm.Product.Repository.RProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SProduct {
    @Autowired
    private RProduct r;

    public List<Product> listProduct(){
        return (List<Product>) r.findAll();
    }


    public Product saveProduct(@Valid DtoProductSave product){
      Product product1 = new Product(product);
      product1.getPrice();
      product1.getNameProduct();
      product1.getStock();
      product1.getImage();
      product1.getDeleted();
      product1.getCategory();
      product1.getBrand();
      return r.save(product1);

    }
}
