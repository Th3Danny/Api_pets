package com.pets.pet.web.controllers;

import com.pets.pet.services.IMedicationsService;
import com.pets.pet.web.dtos.request.MedicationCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medications")
public class MedicationsController {
    private final IMedicationsService medicationsService;

    public MedicationsController(IMedicationsService medicationsService) {
        this.medicationsService = medicationsService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createMedication(@Valid @RequestBody MedicationCreateRequest request) {
        BaseResponse baseResponse = medicationsService.createMedication(request);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getMedicationById(@PathVariable Long id) {
        BaseResponse baseResponse = medicationsService.getMedicationById(id);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllMedications() {
        BaseResponse baseResponse = medicationsService.getAllMedications();
        return baseResponse.buildResponseEntity();
    }


    @GetMapping("/type/{type}")
    public ResponseEntity<BaseResponse> getMedicationsByType(@PathVariable Long id) {
        BaseResponse baseResponse = medicationsService.getMedicationById(id);
        return baseResponse.buildResponseEntity();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteMedication(@PathVariable Long id) {
        BaseResponse baseResponse = medicationsService.deleteMedication(id);
        return baseResponse.buildResponseEntity();
    }
}