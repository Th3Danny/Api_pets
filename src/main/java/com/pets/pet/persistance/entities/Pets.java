package com.pets.pet.persistance.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 40)
    private String name;

    @Column(name = "species",nullable = false, length = 40)
    private String species;

    @Column(name = "breed", nullable = false,length = 40)
    private String breed;

    @Column (name = "birth_date ", nullable = false)
    private LocalDateTime birthDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User idUser;

    @ManyToOne
    private Medications petMedication;

    @ManyToOne
    private Diet petDiet;

    @ManyToOne
    private Vaccines petVaccines;

    public Pets() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Medications getPetMedication() {
        return petMedication;
    }

    public void setPetMedication(Medications petMedication) {
        this.petMedication = petMedication;
    }

    public Diet getPetDiet() {
        return petDiet;
    }

    public void setPetDiet(Diet petDiet) {
        this.petDiet = petDiet;
    }

    public Vaccines getPetVaccines() {
        return petVaccines;
    }

    public void setPetVaccines(Vaccines petVaccines) {
        this.petVaccines = petVaccines;
    }
}
