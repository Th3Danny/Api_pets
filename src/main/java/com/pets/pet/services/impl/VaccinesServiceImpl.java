package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.Vaccines;
import com.pets.pet.persistance.repositories.IVaccinesRepository;
import com.pets.pet.services.IVaccinesService;
import com.pets.pet.web.dtos.request.VaccineCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VaccinesServiceImpl implements IVaccinesService {
    private final IVaccinesRepository vaccinesRepository;

    public VaccinesServiceImpl(IVaccinesRepository vaccinesRepository) {
        this.vaccinesRepository = vaccinesRepository;
    }

    @Override
    public BaseResponse createVaccine(VaccineCreateRequest request) {
        Vaccines vaccine = new Vaccines();
        vaccine.setDateApplied(request.getDateApplied());
        vaccine.setNextDoseDate(request.getNextDoseDate());
        vaccine.setVetName(request.getVetName());

        Vaccines savedVaccine = vaccinesRepository.save(vaccine);

        return BaseResponse.builder()
                .data(savedVaccine)
                .message("Vaccine created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse getVaccineById(Long id) {
        Vaccines vaccine = vaccinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Vaccine not found with id: " + id).getClass()));

        return BaseResponse.builder()
                .data(vaccine)
                .message("Vaccine retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllVaccines() {
        List<Vaccines> vaccines = vaccinesRepository.findAll();

        return BaseResponse.builder()
                .data(vaccines)
                .message("Vaccines retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse deleteVaccine(Long id) {
        Vaccines vaccine = vaccinesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Vaccine not found with id: " + id).getClass()));

        vaccinesRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Vaccine deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}
