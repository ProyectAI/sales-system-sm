package com.example.sales_system_sm.Category.DTO;

import jakarta.validation.constraints.NotBlank;

public record DtoCategorySave(
        @NotBlank
        String nameCategory
) {



}
