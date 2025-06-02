package com.pets.pet.persistance.repositories;

import com.pets.pet.persistance.entities.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IMedicationsRepository extends JpaRepository<Medications, Long> {

    public interface MedicationsRepository extends JpaRepository<Medications, Long> {
        List<Medications> findByIsActive(Boolean isActive);
        List<Medications> findByStartDateBetween(LocalDateTime start, LocalDateTime end);

        @Query("SELECT m FROM Medications m WHERE m.endDate < :currentDate AND m.isActive = true")
        List<Medications> findExpiredActiveMedications(LocalDateTime currentDate);

        @Query("SELECT m FROM Medications m WHERE m.isActive = true ORDER BY m.startDate DESC")
        List<Medications> findActiveMedicationsOrderByDate();
    }

}
