package com.pets.pet.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class MedicationCreateRequest {
    @NotBlank(message = "El nombre del medicamento es obligatorio")
    @Size(max = 40, message = "El nombre no puede exceder 40 caracteres")
    private String name;

    @NotBlank(message = "La dosis es obligatoria")
    @Size(max = 40, message = "La dosis no puede exceder 40 caracteres")
    private String dosage;

    @NotNull(message = "La frecuencia en horas es obligatoria")
    @Positive(message = "La frecuencia debe ser un número positivo")
    private Integer frequencyHours;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDateTime startDate;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDateTime endDate;

    private Boolean isActive = true;

    public MedicationCreateRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getFrequencyHours() {
        return frequencyHours;
    }

    public void setFrequencyHours(Integer frequencyHours) {
        this.frequencyHours = frequencyHours;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
