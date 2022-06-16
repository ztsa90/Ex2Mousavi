package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.model.UserGroup;
import org.example.ex2Mousavi.repository.AuthorizationRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService implements IAuthorizationService {

    AuthorizationRepository authorizationRepository;
    IUserService userService;
    IGroupService groupService;
    IUserGroupService userGroupService;

    public AuthorizationService(AuthorizationRepository authorizationRepository, IUserService userService, IGroupService groupService, IUserGroupService userGroupService)
    {
        this.authorizationRepository = authorizationRepository;
        this.userService = userService;
        this.groupService = groupService;
        this.userGroupService = userGroupService;
    }

    @Override
    public Authorization save(Authorization authorization, Long userId, Long groupId, Long userGroupId) {

        User user = userService.getById(userId);

        Group group = groupService.getById(groupId);
        UserGroup userGroup = userGroupService.getById(userGroupId);

        authorization.setUser(user);
        authorization.setGroup(group);
        authorization.setUserGroup(userGroup);

        return authorizationRepository.save(authorization);}

    @Override
    public Authorization update(Authorization authorization) {
        Long lastId = authorization.getId();
        Optional<Authorization> optionalAuthorization = authorizationRepository.findById(lastId);
        if (optionalAuthorization.isEmpty()) {
            throw new NotFoundException("NO ID");
        }

        Authorization lastAutorization = optionalAuthorization.get();
        String newSource = authorization.getSource();
        UserGroup newUserGroup = authorization.getUserGroup();

        lastAutorization.setSource(newSource);
        lastAutorization.setUserGroup(newUserGroup);
        Authorization newAuthorization = authorizationRepository.save(lastAutorization);
        return newAuthorization;
    }

    @Override
    public Authorization getById(Long id) {
        Optional<Authorization> optionalAuthorization = authorizationRepository.findById(id);
        if (optionalAuthorization.isEmpty()) {
            throw new NotFoundException("NO ID");
        }
        return optionalAuthorization.get();
    }

    @Override
    public List<Authorization> getAll() {
        return (List<Authorization>) authorizationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        authorizationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        authorizationRepository.deleteAll();
    }



    @Override
    public List<Authorization> findAuthorizationByGroupIdAndUserId(Long groupId, Long userId) {
        return authorizationRepository.findAuthorizationByGroupIdAndUserId(groupId,userId);
    }


//    @Override
//    public List<Authorization> findAuthorizationByUserIdAndUserGroupId(Long userId, Long userGroupId) {
//        return authorizationRepository.findAuthorizationByUserIdAndUserGroupId(userId,userGroupId);
//    }

}
