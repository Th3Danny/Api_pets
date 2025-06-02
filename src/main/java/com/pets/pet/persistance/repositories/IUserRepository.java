package com.pets.pet.persistance.repositories;

import com.pets.pet.persistance.entities.User;
import com.pets.pet.persistance.entities.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository <User, Long>{
    @Query(value = "SELECT * FROM user AS u WHERE u.email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user u WHERE u.name = :name", nativeQuery = true)
    Optional<User> findByName(String name);

    boolean existsByEmail(String email);
}


