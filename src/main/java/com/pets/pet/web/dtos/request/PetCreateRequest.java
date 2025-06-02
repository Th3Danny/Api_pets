package com.pets.pet.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class PetCreateRequest {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 40, message = "El nombre no puede exceder 40 caracteres")
    private String name;

    @NotBlank(message = "La especie es obligatoria")
    @Size(max = 40, message = "La especie no puede exceder 40 caracteres")
    private String species;

    @NotBlank(message = "La raza es obligatoria")
    @Size(max = 40, message = "La raza no puede exceder 40 caracteres")
    private String breed;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDateTime birthDate;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long userId;

    // Campos opcionales para medicamentos, dietas y vacunas
    private Long medicationId;
    private Long dietId;
    private Long vaccineId;

    public PetCreateRequest() {}

    // Getters y setters existentes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Nuevos getters y setters para los campos opcionales
    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public Long getDietId() {
        return dietId;
    }

    public void setDietId(Long dietId) {
        this.dietId = dietId;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }
}