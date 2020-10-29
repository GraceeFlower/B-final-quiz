package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should not be empty!")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainer> trainers = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();
}
