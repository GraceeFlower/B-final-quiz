package com.example.demo.service;

import com.example.demo.controller.dto.requestdto.TraineeRequestDTO;
import com.example.demo.entity.Trainee;
import com.example.demo.exception.InvalidPersonException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TraineeService {

    private final AtomicLong traineeIdSeq = new AtomicLong();
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee createTrainee(TraineeRequestDTO traineeRequestDTO) {
        // TODO GTB-知识点: - JPA的Entity已经定义了自动生成的id
        Trainee trainee = new Trainee(
                traineeIdSeq.incrementAndGet(),
                traineeRequestDTO.getName(),
                false);
        return traineeRepository.save(trainee);
    }

    public List<Trainee> getTrainees(Boolean grouped) {
        // TODO GTB-知识点: - grouped=true时，应返回已经分组学员
        return grouped ? new ArrayList<>()
                : traineeRepository.findByGroupedIsFalse();
    }

    public void deleteTrainee(Long id) {
        traineeRepository.findById(id)
                .orElseThrow(() -> new InvalidPersonException("Trainee is not exist!"));
        traineeRepository.deleteById(id);
    }
}
