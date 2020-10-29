package com.example.demo.controller;

import com.example.demo.entity.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/trainees")
    public List<Trainee> getTrainees(@RequestParam(name = "grouped") Boolean grouped) {
        return traineeService.getTrainees(grouped);
    }
}
