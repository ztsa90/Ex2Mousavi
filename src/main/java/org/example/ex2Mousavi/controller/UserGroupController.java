package org.example.ex2Mousavi.controller;

import org.example.ex2Mousavi.model.UserGroup;
import org.example.ex2Mousavi.dto.UserGroupDTO;
import org.example.ex2Mousavi.mapper.UserGroupMapper;
import org.example.ex2Mousavi.mapper.UserMapper;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.repository.UserGroupRepository;
import org.example.ex2Mousavi.repository.UserRepository;
import org.example.ex2Mousavi.service.IGroupService;
import org.example.ex2Mousavi.service.IUserGroupService;
import org.example.ex2Mousavi.service.IUserService;
import org.example.ex2Mousavi.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/userGroups1")

public class UserGroupController {
    IUserGroupService userGroupService;
    IGroupService groupService;
    IUserService userService;
    UserGroupMapper userGroupMapper;
    UserMapper userMapper;

    public UserGroupController(IUserGroupService userGroupService, IGroupService groupService, IUserService userService, UserGroupMapper userGroupMapper, UserMapper userMapper) {
        this.userGroupService = userGroupService;
        this.groupService = groupService;
        this.userService = userService;
        this.userGroupMapper = userGroupMapper;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "/save/{userId}/{groupId}")
    public ResponseEntity<UserGroupDTO> save(@RequestBody UserGroupDTO userGroupDTO, @PathVariable Long userId, @PathVariable Long groupId) {
        User user = userService.getById(userId);
        Group group = groupService.getById(groupId);
        UserGroup userGroup = userGroupMapper.toEntity(userGroupDTO);
        userGroup.setGroup(group);
        userGroup.setUser(user);
        UserGroup save = userGroupService.save(userGroup, userId, groupId);
        UserGroupDTO userGroupDTO1 = userGroupMapper.toDTO(save);
        return new ResponseEntity<>(userGroupDTO1, HttpStatus.OK);
    }

    @GetMapping(value = "/update")
    public ResponseEntity<UserGroupDTO> update(@RequestBody UserGroupDTO userGroupDTO) {
        UserGroup userGroup = userGroupMapper.toEntity(userGroupDTO);
        UserGroup userGroup1 = userGroupService.update(userGroup);
        UserGroupDTO userGroupDTO1 = userGroupMapper.toDTO(userGroup1);
        return new ResponseEntity<>(userGroupDTO1, HttpStatus.OK);
    }


    @GetMapping("/findUserGroupByUserAndGroupId/{userId}/{groupId}")
    public ResponseEntity<List<UserGroupDTO>> findUserGroupByUserAndGroupId(@PathVariable Long userId, @PathVariable Long groupId) {

        List<UserGroup> userGroups = userGroupService.findUserGroupByUserAndGroupId(userId, groupId);
        List<UserGroupDTO> userGroupDTO1 = userGroupMapper.toDTOs(userGroups);
        return new ResponseEntity<>(userGroupDTO1, HttpStatus.OK);
    }


    @GetMapping(value = "/getById/{userGroupId}")
    public ResponseEntity<UserGroupDTO> getById(@PathVariable Long userGroupId) {
        UserGroup userGroup = userGroupService.getById(userGroupId);
        UserGroupDTO userGroupDTO = userGroupMapper.toDTO(userGroup);
        return new ResponseEntity<>(userGroupDTO,HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById/{userGroupId}")

    public void deleteById(@PathVariable Long userGroupId) {

        userGroupService.deleteById(userGroupId);
    }

}

