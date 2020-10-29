package com.example.demo.controller;

import com.example.demo.controller.dto.requestdto.TraineeRequestDTO;
import com.example.demo.controller.dto.responsedeto.TraineeResponseDTO;
import com.example.demo.controller.dto.responsedeto.TraineesResponseDTO;
import com.example.demo.service.TraineeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainees")
@CrossOrigin("http://localhost:1234")
@Validated
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    public List<TraineeResponseDTO> getTrainees(@RequestParam(name = "grouped") Boolean grouped) {
        return new TraineesResponseDTO().toList(traineeService.getTrainees(grouped));
    }

    @PostMapping
    public TraineeResponseDTO createTrainee(@RequestBody @Valid TraineeRequestDTO traineeRequestDTO) {
        return new TraineeResponseDTO(traineeService.createTrainee(traineeRequestDTO));
    }
}
