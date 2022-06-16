package org.example.ex2Mousavi.controller;


import org.example.ex2Mousavi.dto.GroupDTO;
import org.example.ex2Mousavi.dto.UserGroupDTO;
import org.example.ex2Mousavi.mapper.GroupMapper;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.UserGroup;
import org.example.ex2Mousavi.repository.GroupRepository;
import org.example.ex2Mousavi.service.IGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {
    IGroupService groupService;
    GroupMapper groupMapper;

    public GroupController(IGroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<GroupDTO> save(GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        group = groupService.save(group);
        GroupDTO groupDTO1 = groupMapper.toDTO(group);
        return new ResponseEntity<>(groupDTO1, HttpStatus.OK);
    }

//    @GetMapping(value = "/findById/{groupId}")
//    public ResponseEntity<GroupDTO> findById(@PathVariable Long groupId) {
//
//        Group group =groupService.findById(groupId);
//        GroupDTO groupDTO = groupMapper.toDTO(group);
//        return new ResponseEntity<>(groupDTO, HttpStatus.OK);
//    }

    @GetMapping(value = "/getById/{groupId}")
    public ResponseEntity<GroupDTO> getById(@PathVariable Long groupId) {
        Group group = groupService.getById(groupId);
        GroupDTO groupDTO = groupMapper.toDTO(group);
        return new ResponseEntity<>(groupDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public  ResponseEntity<List<GroupDTO>> getAll() {
        List<Group> groups= groupService.getAll();
        List<GroupDTO> groupDTOs = groupMapper.toDTOs(groups);
        return new ResponseEntity<>(groupDTOs,HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteById/{GroupId}")

    public void deleteById(@PathVariable Long GroupId) {

        groupService.deleteById(GroupId);
    }

    @GetMapping(value = "/update")
    public ResponseEntity<GroupDTO> update(@RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        Group group1 = groupService.update(group);
        GroupDTO groupDTO1 = groupMapper.toDTO(group1);
        return new ResponseEntity<>(groupDTO1, HttpStatus.OK);
    }
}
