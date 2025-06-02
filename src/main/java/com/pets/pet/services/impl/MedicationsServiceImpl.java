package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.Medications;
import com.pets.pet.persistance.repositories.IMedicationsRepository;
import com.pets.pet.services.IMedicationsService;
import com.pets.pet.web.dtos.request.MedicationCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicationsServiceImpl implements IMedicationsService {
    private final IMedicationsRepository medicationsRepository;

    public MedicationsServiceImpl(IMedicationsRepository medicationsRepository) {
        this.medicationsRepository = medicationsRepository;
    }

    @Override
    public BaseResponse createMedication(MedicationCreateRequest request) {
        Medications medication = new Medications();
        medication.setName(request.getName());
        medication.setDosage(request.getDosage());
        medication.setFrequencyHours(request.getFrequencyHours());
        medication.setStartDate(request.getStartDate());
        medication.setEndDate(request.getEndDate());
        medication.setIsActive(true); // Por defecto activo

        Medications savedMedication = medicationsRepository.save(medication);

        return BaseResponse.builder()
                .data(savedMedication)
                .message("Medication created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse getMedicationById(Long id) {
        Medications medication = medicationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Medication not found with id: " + id).getClass()));

        return BaseResponse.builder()
                .data(medication)
                .message("Medication retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllMedications() {
        List<Medications> medications = medicationsRepository.findAll();

        return BaseResponse.builder()
                .data(medications)
                .message("Medications retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public BaseResponse deleteMedication(Long id) {
        Medications medication = medicationsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Medication not found with id: " + id).getClass()));

        medicationsRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Medication deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
