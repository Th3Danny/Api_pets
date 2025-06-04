package com.pets.pet.web.dtos.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class DietUpdateRequest {
    @NotBlank(message = "Meal name is required")
    @Size(max = 50, message = "Meal name must not exceed 50 characters")
    private String mealName;

    @NotBlank(message = "Quantity is required")
    @Size(max = 50, message = "Quantity must not exceed 50 characters")
    private String quantity;

    @NotBlank(message = "Schedule is required")
    @Size(max = 50, message = "Schedule must not exceed 50 characters")
    private String schedule;

    @NotBlank(message = "Notes are required")
    @Size(max = 200, message = "Notes must not exceed 200 characters")
    private String notes;
}