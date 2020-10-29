package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Trainee;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TraineesResponseDTO {

    public List<TraineeResponseDTO> toList(List<Trainee> trainees) {
        return trainees.stream()
                .map(TraineeResponseDTO::new)
                .collect(Collectors.toList());
    }
}
