package com.example.demo.controller.dto.responsedeto;

import com.example.demo.entity.Group;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GroupsResponseDTO {

    public List<GroupResponseDTO> toList(List<Group> groupList) {
        return groupList.stream()
                .map(GroupResponseDTO::new)
                .collect(Collectors.toList());
    }
}
