package com.example.demo.controller;

import com.example.demo.controller.dto.responsedeto.TrainerResponseDTO;
import com.example.demo.controller.dto.responsedeto.TrainersResponseDTO;
import com.example.demo.service.TrainerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public List<TrainerResponseDTO> getTrainers(@RequestParam(name = "grouped") Boolean grouped) {
        return new TrainersResponseDTO().toList(trainerService.getTrainers(grouped));
    }

}
