package com.pets.pet.web.dtos.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
public class MedicationUpdateRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 40, message = "Name must not exceed 40 characters")
    private String name;

    @NotBlank(message = "Dosage is required")
    @Size(max = 40, message = "Dosage must not exceed 40 characters")
    private String dosage;

    @NotNull(message = "Frequency hours is required")
    @Min(value = 1, message = "Frequency hours must be at least 1")
    private Integer frequencyHours;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    @NotNull(message = "Active status is required")
    private Boolean isActive;
}
