package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.Diet;
import com.pets.pet.persistance.repositories.IDietRepository;
import com.pets.pet.services.IDietService;
import com.pets.pet.web.dtos.request.DietCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DietServiceImpl implements IDietService {
    private final IDietRepository dietRepository;

    public DietServiceImpl(IDietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    @Override
    public BaseResponse createDiet(DietCreateRequest request) {
        Diet diet = new Diet();
        diet.setMealName(request.getMealName());
        diet.setQuantity(request.getQuantity());
        diet.setSchedule(request.getSchedule());
        diet.setNotes(request.getNotes());

        Diet savedDiet = dietRepository.save(diet);

        return BaseResponse.builder()
                .data(savedDiet)
                .message("Diet created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse getDietById(Long id) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Diet not found with id: " + id).getClass()));

        return BaseResponse.builder()
                .data(diet)
                .message("Diet retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllDiets() {
        List<Diet> diets = dietRepository.findAll();

        return BaseResponse.builder()
                .data(diets)
                .message("Diets retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public BaseResponse deleteDiet(Long id) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Diet not found with id: " + id).getClass()));

        dietRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Diet deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
