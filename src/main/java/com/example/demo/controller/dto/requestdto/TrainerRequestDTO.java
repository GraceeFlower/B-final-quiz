package com.example.demo.controller.dto.requestdto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TrainerRequestDTO {
    @NotEmpty(message = "Name should not be empty!")
    private String Name;
}
