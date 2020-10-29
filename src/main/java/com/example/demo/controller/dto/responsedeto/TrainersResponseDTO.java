package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Trainer;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TrainersResponseDTO {

    public List<TrainerResponseDTO> toList(List<Trainer> trainers) {
        return trainers.stream()
                .map(TrainerResponseDTO::new)
                .collect(Collectors.toList());
    }
}

