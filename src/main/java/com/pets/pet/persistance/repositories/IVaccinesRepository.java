package com.pets.pet.persistance.repositories;

import com.pets.pet.persistance.entities.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IVaccinesRepository extends JpaRepository<Vaccines, Long> {
    List<Vaccines> findByVetName(String vetName);
    List<Vaccines> findByDateAppliedBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT v FROM Vaccines v WHERE v.nextDoseDate BETWEEN :start AND :end")
    List<Vaccines> findUpcomingVaccines(LocalDateTime start, LocalDateTime end);

    @Query("SELECT v FROM Vaccines v WHERE v.nextDoseDate < :currentDate")
    List<Vaccines> findOverdueVaccines(LocalDateTime currentDate);
}