package com.example.demo.controller;

import com.example.demo.controller.dto.requestdto.TrainerRequestDTO;
import com.example.demo.controller.dto.responsedeto.TrainerResponseDTO;
import com.example.demo.controller.dto.responsedeto.TrainersResponseDTO;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainers")
@CrossOrigin("http://localhost:1234")
// TODO GTB-知识点: - 此处的@Validated注解是多余的
@Validated
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<TrainerResponseDTO> getTrainers(@RequestParam(name = "grouped") Boolean grouped) {
        return new TrainersResponseDTO().toList(trainerService.getTrainers(grouped));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponseDTO createTrainer(@RequestBody @Valid TrainerRequestDTO trainerRequestDTO) {
        return new TrainerResponseDTO(trainerService.createTrainer(trainerRequestDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }
}
