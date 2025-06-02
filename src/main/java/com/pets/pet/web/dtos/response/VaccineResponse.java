package com.pets.pet.web.dtos.response;

import java.time.LocalDateTime;

public class VaccineResponse {
    private Long id;
    private LocalDateTime dateApplied;
    private LocalDateTime nextDoseDate;
    private String vetName;

    public VaccineResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
