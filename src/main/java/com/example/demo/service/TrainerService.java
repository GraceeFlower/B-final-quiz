package com.example.demo.service;

import com.example.demo.entity.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers(Boolean grouped) {
        return grouped ? new ArrayList<>()
                : trainerRepository.findByGroupedIsFalse();
    }
}
