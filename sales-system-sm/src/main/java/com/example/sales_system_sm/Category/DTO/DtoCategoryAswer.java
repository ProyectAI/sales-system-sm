package com.example.sales_system_sm.Category.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoCategoryAswer(

        Long id,
        @NotBlank
        String nameCategory,
        @NotNull
        Boolean deleted

) {
}
