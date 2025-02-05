package com.example.sales_system_sm.Product.DTO;

import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Category.Model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoProductSave(

        @NotNull
        String price,
        @NotBlank
        String nameProduct,
        @NotNull
        String stock,
        Boolean deleted,
        Category category,
        Brand brand
) {
}
