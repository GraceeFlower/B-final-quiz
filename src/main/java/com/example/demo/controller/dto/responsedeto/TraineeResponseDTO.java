package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Trainee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraineeResponseDTO {
    private Long id;
    private String name;

    public TraineeResponseDTO(Trainee trainee) {
        this.id = trainee.getId();
        this.name = trainee.getName();
    }
}
