package com.pets.pet.web.controllers;

import com.pets.pet.services.IVaccinesService;
import com.pets.pet.web.dtos.request.VaccineCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccines")
public class VaccinesController {
    private final IVaccinesService vaccinesService;

    public VaccinesController(IVaccinesService vaccinesService) {
        this.vaccinesService = vaccinesService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createVaccine(@Valid @RequestBody VaccineCreateRequest request) {
        BaseResponse baseResponse = vaccinesService.createVaccine(request);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getVaccineById(@PathVariable Long id) {
        BaseResponse baseResponse = vaccinesService.getVaccineById(id);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllVaccines() {
        BaseResponse baseResponse = vaccinesService.getAllVaccines();
        return baseResponse.buildResponseEntity();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteVaccine(@PathVariable Long id) {
        BaseResponse baseResponse = vaccinesService.deleteVaccine(id);
        return baseResponse.buildResponseEntity();
    }
}