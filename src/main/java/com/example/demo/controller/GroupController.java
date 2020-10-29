package com.example.demo.controller;

import com.example.demo.controller.dto.responsedeto.GroupResponseDTO;
import com.example.demo.controller.dto.responsedeto.GroupsResponseDTO;
import com.example.demo.service.GroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
@Validated
@CrossOrigin("http://localhost:1234")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupResponseDTO> getAllGroups() {
        return new GroupsResponseDTO().toList(groupService.getAllGroups());
    }
}

