package com.example.demo.controller;

import com.example.demo.controller.dto.responsedeto.TraineeResponseDTO;
import com.example.demo.controller.dto.responsedeto.TraineesResponseDTO;
import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import com.example.demo.service.TraineeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/trainees")
    public List<TraineeResponseDTO> getTrainees(@RequestParam(name = "grouped") Boolean grouped) {
        return new TraineesResponseDTO().toList(traineeService.getTrainees(grouped));
    }
}
