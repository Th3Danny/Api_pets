package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.*;
import com.pets.pet.persistance.repositories.*;
import com.pets.pet.services.IPetsService;
import com.pets.pet.web.dtos.request.PetCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetsServiceImpl implements IPetsService {
    private final IPetsRepository petsRepository;
    private final IUserRepository userRepository;
    private final IMedicationsRepository medicationsRepository;
    private final IDietRepository dietRepository;
    private final IVaccinesRepository vaccinesRepository;

    public PetsServiceImpl(IPetsRepository petsRepository, IUserRepository userRepository,
                           IMedicationsRepository medicationsRepository, IDietRepository dietRepository,
                           IVaccinesRepository vaccinesRepository) {
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
        this.medicationsRepository = medicationsRepository;
        this.dietRepository = dietRepository;
        this.vaccinesRepository = vaccinesRepository;
    }

    @Override
    public BaseResponse createPet(PetCreateRequest request) {
        // Verificar que el usuario existe
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException(User.class));

        // Crear nueva mascota
        Pets pet = new Pets();
        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setBreed(request.getBreed());
        pet.setBirthDate(request.getBirthDate());
        pet.setIdUser(user);

        // Asignar medicamento si se proporciona
        if (request.getMedicationId() != null) {
            Medications medication = medicationsRepository.findById(request.getMedicationId())
                    .orElseThrow(() -> new ResourceNotFoundException(("Medication not found with id: " + request.getMedicationId()).getClass()));
            pet.setPetMedication(medication);
        }

        // Asignar dieta si se proporciona
        if (request.getDietId() != null) {
            Diet diet = dietRepository.findById(request.getDietId())
                    .orElseThrow(() -> new ResourceNotFoundException(("Diet not found with id: " + request.getDietId()).getClass()));
            pet.setPetDiet(diet);
        }

        // Asignar vacuna si se proporciona
        if (request.getVaccineId() != null) {
            Vaccines vaccine = vaccinesRepository.findById(request.getVaccineId())
                    .orElseThrow(() -> new ResourceNotFoundException(("Vaccine not found with id: " + request.getVaccineId()).getClass()));
            pet.setPetVaccines(vaccine);
        }

        Pets savedPet = petsRepository.save(pet);

        return BaseResponse.builder()
                .data(savedPet)
                .message("Pet created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse getPetById(Long id) {
        Pets pet = petsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Pet not found with id: " + id).getClass()));

        return BaseResponse.builder()
                .data(pet)
                .message("Pet retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllPets() {
        List<Pets> pets = petsRepository.findAll();

        return BaseResponse.builder()
                .data(pets)
                .message("Pets retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getPetsByUserId(Long userId) {
        // Verificar que el usuario existe
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(("User not found with id: " + userId).getClass()));

        List<Pets> pets = petsRepository.findPetsByUserId(userId);

        return BaseResponse.builder()
                .data(pets)
                .message("User pets retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getPetsBySpecies(String species) {
        List<Pets> pets = petsRepository.findBySpecies(species);

        return BaseResponse.builder()
                .data(pets)
                .message("Pets filtered by species retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse deletePet(Long id) {
        Pets pet = petsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Pet not found with id: " + id).getClass()));

        petsRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Pet deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

}
