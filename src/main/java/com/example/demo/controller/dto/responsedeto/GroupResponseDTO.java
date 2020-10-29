package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Group;
import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import lombok.Data;

import java.util.List;

@Data
public class GroupResponseDTO {

    private Long id;
    private String name;
    private List<TrainerResponseDTO> trainerList;
    private List<TraineeResponseDTO> traineeList;

    public GroupResponseDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.trainerList = new TrainersResponseDTO().toList(group.getTrainers());
        this.traineeList = new TraineesResponseDTO().toList(group.getTrainees());
    }
}
