package com.pets.pet.web.controllers;

import com.pets.pet.services.IDietService;
import com.pets.pet.web.dtos.request.DietCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diets")
class DietController {
    private final IDietService dietService;

    public DietController(IDietService dietService) {
        this.dietService = dietService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createDiet(@Valid @RequestBody DietCreateRequest request) {
        BaseResponse baseResponse = dietService.createDiet(request);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getDietById(@PathVariable Long id) {
        BaseResponse baseResponse = dietService.getDietById(id);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllDiets() {
        BaseResponse baseResponse = dietService.getAllDiets();
        return baseResponse.buildResponseEntity();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteDiet(@PathVariable Long id) {
        BaseResponse baseResponse = dietService.deleteDiet(id);
        return baseResponse.buildResponseEntity();
    }
}
