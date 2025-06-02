package com.pets.pet.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DietCreateRequest {
    @NotBlank(message = "El nombre de la comida es obligatorio")
    @Size(max = 50, message = "El nombre de la comida no puede exceder 50 caracteres")
    private String mealName;

    @NotBlank(message = "La cantidad es obligatoria")
    @Size(max = 50, message = "La cantidad no puede exceder 50 caracteres")
    private String quantity;

    @NotBlank(message = "El horario es obligatorio")
    @Size(max = 50, message = "El horario no puede exceder 50 caracteres")
    private String schedule;

    @Size(max = 200, message = "Las notas no pueden exceder 200 caracteres")
    private String notes;

    // Constructores
    public DietCreateRequest() {}

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
