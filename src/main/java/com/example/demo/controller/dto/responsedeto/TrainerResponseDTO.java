package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponseDTO {
    private Long id;
    private String name;

    public TrainerResponseDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.name = trainer.getName();
    }
}

