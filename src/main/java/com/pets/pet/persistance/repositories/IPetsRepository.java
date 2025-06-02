package com.pets.pet.persistance.repositories;

import com.pets.pet.persistance.entities.Pets;
import com.pets.pet.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetsRepository extends JpaRepository <Pets, Long> {
    List<Pets> findByIdUser (User user);
    List<Pets> findBySpecies (String species);
    List<Pets> findByIdUserAndSpecies (User user, String species);

    @Query("SELECT p FROM Pets p WHERE p.name LIKE %:name%")
    List<Pets> findByNameContaining(String name);

    @Query("SELECT p FROM Pets p WHERE p.idUser.id = :userId")
    List<Pets> findPetsByUserId(Long userId);
}
