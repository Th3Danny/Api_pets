package com.pets.pet.web.dtos.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class VaccineUpdateRequest {
    @NotNull(message = "Date applied is required")
    private LocalDateTime dateApplied;

    @NotNull(message = "Next dose date is required")
    private LocalDateTime nextDoseDate;

    @NotBlank(message = "Vet name is required")
    @Size(max = 100, message = "Vet name must not exceed 100 characters")
    private String vetName;
}