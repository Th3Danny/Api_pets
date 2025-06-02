package com.pets.pet.persistance.repositories;

import com.pets.pet.persistance.entities.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDietRepository extends JpaRepository <Diet, Long> {
    List<Diet> findByMealName(String mealName);
    List<Diet> findBySchedule(String schedule);

    @Query("SELECT d FROM Diet d WHERE d.mealName LIKE %:mealName%")
    List<Diet> findByMealNameContaining(String mealName);

    @Query("SELECT d FROM Diet d ORDER BY d.schedule")
    List<Diet> findAllOrderBySchedule();
}
