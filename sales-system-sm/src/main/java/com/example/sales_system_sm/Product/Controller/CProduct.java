package com.example.sales_system_sm.Product.Controller;

import com.example.sales_system_sm.Brand.DTO.DtoBrandAswer;
import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Category.DTO.DtoCategorySave;
import com.example.sales_system_sm.Product.DTO.DtoProductAswer;
import com.example.sales_system_sm.Product.DTO.DtoProductSave;
import com.example.sales_system_sm.Product.Model.Product;
import com.example.sales_system_sm.Product.Service.SProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/product")
@RestController
public class CProduct {


    @Autowired
    private SProduct s;

    @GetMapping
    public List<Product> productList(){
        return s.listProduct();
    }

    @PostMapping("/save")
    public ResponseEntity<DtoProductAswer> saveProduct(@RequestBody @Valid DtoProductSave dtoProductSave, UriComponentsBuilder uriComponentsBuilder){
        Product product = s.saveProduct(dtoProductSave);
        DtoProductAswer dtoProductAswer= new DtoProductAswer(product.getId(), product.getPrice(), product.getNameProduct(), product.getStock(),
                product.getImage(), product.getDeleted());
        URI url= uriComponentsBuilder.path("/save/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(url).body(dtoProductAswer);
    }
}
