package com.pets.pet.web.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PetUpdateRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 40, message = "Name must not exceed 40 characters")
    private String name;

    @Min(0)
    @Max(50)
    private Long age;

    @NotBlank(message = "Species is required")
    @Size(max = 40, message = "Species must not exceed 40 characters")
    private String species;

    @NotBlank(message = "Breed is required")
    @Size(max = 40, message = "Breed must not exceed 40 characters")
    private String breed;

    @NotNull(message = "Birth date is required")
    private LocalDateTime birthDate;

    private Long medicationId;
    private Long dietId;
    private Long vaccineId;

    public PetUpdateRequest() {}

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
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
