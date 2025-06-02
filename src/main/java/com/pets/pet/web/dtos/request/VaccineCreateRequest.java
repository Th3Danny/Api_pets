package com.pets.pet.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class VaccineCreateRequest {
    @NotNull(message = "La fecha de aplicación es obligatoria")
    private LocalDateTime dateApplied;

    @NotNull(message = "La fecha de próxima dosis es obligatoria")
    private LocalDateTime nextDoseDate;

    @NotBlank(message = "El nombre del veterinario es obligatorio")
    @Size(max = 100, message = "El nombre del veterinario no puede exceder 100 caracteres")
    private String vetName;

    public VaccineCreateRequest() {}

    public LocalDateTime getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDateTime dateApplied) {
        this.dateApplied = dateApplied;
    }

    public LocalDateTime getNextDoseDate() {
        return nextDoseDate;
    }

    public void setNextDoseDate(LocalDateTime nextDoseDate) {
        this.nextDoseDate = nextDoseDate;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
}
