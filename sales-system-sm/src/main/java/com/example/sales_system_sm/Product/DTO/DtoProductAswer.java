package com.example.sales_system_sm.Product.DTO;

import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Category.Model.Category;
import jakarta.persistence.*;

public record DtoProductAswer(

         Long id,
         String price,
         String nameProduct,
         String stock,
         String image,
         Boolean deleted


) {


}
