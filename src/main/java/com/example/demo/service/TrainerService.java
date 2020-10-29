package com.example.demo.service;

import com.example.demo.controller.dto.requestdto.TrainerRequestDTO;
import com.example.demo.entity.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrainerService {

    private final AtomicLong trainerIdSeq = new AtomicLong();
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers(Boolean grouped) {
        return grouped ? new ArrayList<>()
                : trainerRepository.findByGroupedIsFalse();
    }

    public Trainer createTrainer(TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = new Trainer(
                trainerIdSeq.incrementAndGet(),
                trainerRequestDTO.getName(),
                false
        );
        return trainerRepository.save(trainer);
    }
}
