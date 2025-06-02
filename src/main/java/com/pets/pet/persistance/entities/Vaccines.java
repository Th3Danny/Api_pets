package com.pets.pet.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
public class Vaccines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_applied", nullable = false)
    private LocalDateTime dateApplied;

    @Column(name = "next_dose_date", nullable = false)
    private LocalDateTime nextDoseDate;

    @Column (name = "vet_name", nullable = false)
    private String vetName;

    public Vaccines(){}

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
