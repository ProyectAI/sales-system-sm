package com.example.sales_system_sm.Brand.DTO;

import com.example.sales_system_sm.Product.Model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DtoBrandSave(
        @NotBlank
        String nameBrand


) {
}
