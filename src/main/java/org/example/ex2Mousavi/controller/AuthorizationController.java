package org.example.ex2Mousavi.controller;

import org.example.ex2Mousavi.dto.AuthorizationDTO;
import org.example.ex2Mousavi.dto.UserGroupDTO;
import org.example.ex2Mousavi.mapper.AuthorizationMapper;
import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.model.UserGroup;
import org.example.ex2Mousavi.service.IAuthorizationService;
import org.example.ex2Mousavi.service.IGroupService;
import org.example.ex2Mousavi.service.IUserGroupService;
import org.example.ex2Mousavi.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorizations")
public class AuthorizationController {

    IAuthorizationService authorizationService;
    IUserService userService;
    IGroupService groupService;
    AuthorizationMapper authorizationMapper;
    IUserGroupService userGroupService;

    public AuthorizationController(IAuthorizationService authorizationService, IUserService userService, IGroupService groupService, AuthorizationMapper authorizationMapper, IUserGroupService userGroupService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
        this.groupService = groupService;
        this.authorizationMapper = authorizationMapper;
        this.userGroupService = userGroupService;
    }


    @PostMapping("/save/{userId}/{groupId}")
    public ResponseEntity<AuthorizationDTO> save(@RequestBody AuthorizationDTO authorizationDTO, @PathVariable Long userId, @PathVariable Long groupId, @PathVariable Long userGroupId) {
        {
            Authorization authorization = authorizationMapper.toEntity(authorizationDTO);

            User user = userService.getById(userId);
            Group group = groupService.getById(groupId);
            UserGroup userGroup = userGroupService.getById(userGroupId);

            authorization.setUser(user);
            authorization.setGroup(group);
            Authorization authorization1 = authorizationService.save(authorization, userId, groupId, userGroupId);

            return new ResponseEntity<>(authorizationMapper.toDTO(authorization1), HttpStatus.OK);
        }
    }
////////////find

    @GetMapping(value = "/findAuthorizationByGroupIdAndUserId/{groupId}/{userId}")
    public ResponseEntity<List<AuthorizationDTO>> findAuthorizationByGroupIdAndUserId(@PathVariable Long groupId, @PathVariable Long userId) {
        List<Authorization> authorizations = authorizationService.findAuthorizationByGroupIdAndUserId(groupId,userId);
        List<AuthorizationDTO> authorizationDTO1 = authorizationMapper.toDTOs(authorizations);
        return new ResponseEntity<>(authorizationDTO1, HttpStatus.OK);
    }

//    @GetMapping(value = "/findAuthorizationByGroupIdAndUserGroupId/{groupId}/{userGroupId}")
//    public ResponseEntity<List<AuthorizationDTO>> findAuthorizationByGroupIdAndUseGroupId(@PathVariable Long groupId, @PathVariable Long userGroupId) {
//
//        List<Authorization> authorizations = authorizationService.findAuthorizationByGroupIdAndUserId(groupId, userGroupId);
//        List<AuthorizationDTO> authorizationDTO1 = authorizationMapper.toDTOs(authorizations);
//        return new ResponseEntity<>(authorizationDTO1, HttpStatus.OK);
//    }

//    @GetMapping(value = "/findAuthorizationByUserIdAndUserGroupId/{userId}/{userGroupId}/")
//    public ResponseEntity<List<AuthorizationDTO>> findAuthorizationByUserIdAndUserGroupId(@PathVariable Long userId, @PathVariable Long userGroupId) {
//
//        List<Authorization> authorizations = authorizationService.findAuthorizationByGroupIdAndUserId(userId, userGroupId);
//        List<AuthorizationDTO> authorizationDTO1 = authorizationMapper.toDTOs(authorizations);
//        return new ResponseEntity<>(authorizationDTO1, HttpStatus.OK);
//
//    }

////////////////
    @GetMapping(value = "/getById/{authorizationId}")
    public ResponseEntity<AuthorizationDTO> getByID(@PathVariable Long authorizationId) {

        Authorization authorization = authorizationService.getById(authorizationId);

        AuthorizationDTO authorizationDTO1 = authorizationMapper.toDTO(authorization);

        return new ResponseEntity<>(authorizationDTO1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        authorizationService.deleteAll();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<AuthorizationDTO> update(@RequestBody AuthorizationDTO authorizationDTO) {

        Authorization authorization = authorizationMapper.toEntity(authorizationDTO);
        Authorization authorization1 = authorizationService.update(authorization);

        AuthorizationDTO authorizationDTO1 = authorizationMapper.toDTO(authorization1);
        return new ResponseEntity<>(authorizationDTO1, HttpStatus.OK);
    }

}
