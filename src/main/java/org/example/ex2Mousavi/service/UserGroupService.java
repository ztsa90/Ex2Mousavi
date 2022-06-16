package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.model.UserGroup;
import org.example.ex2Mousavi.repository.UserGroupRepository;
import org.example.ex2Mousavi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
public class UserGroupService implements IUserGroupService {

    UserGroupRepository userGroupRepository;
    UserRepository userRepository;
    IUserService userService;
    IGroupService groupService;

    public UserGroupService(UserGroupRepository userGroupRepository, UserRepository userRepository, IUserService userService, IUserService userService1) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.userService = userService1;
    }

    @Override
    public UserGroup save(UserGroup userGroup, Long userId, Long groupId) {
        User user = userService.getById(userId);
        Group group = groupService.getById(groupId);
        userGroup.setUser(user);
        userGroup.setGroup(group);
        return userGroupRepository.save(userGroup);
    }

    @Override
    public List<UserGroup> findUserGroupByUserAndGroupId(Long userId, Long groupId)
    {
        User user = userService.getById(userId);
        Group group = groupService.getById(groupId);
        return userGroupRepository.findUserGroupByUserAndGroupId(userId,groupId);
    }


    @Override
    public UserGroup getById(Long groupId) {
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(groupId);
        if (optionalUserGroup.isEmpty()) {
            throw new NotFoundException("no id");
        }
        return optionalUserGroup.get();
    }



    public List<UserGroup> getAll() {
        return (List<UserGroup>) userGroupRepository.findAll();
    }

    @Override
    public UserGroup update(UserGroup userGroup) {
        Long lastId = userGroup.getId();
        Optional<UserGroup> optionalUserGroup = userGroupRepository.findById(lastId);
        if (optionalUserGroup.isEmpty()) {
            throw new NotFoundException("no id");
        }
        UserGroup lastUserGroup = optionalUserGroup.get();
        Boolean newActive = userGroup.getActive();
        lastUserGroup.setActive(newActive);
        UserGroup newUserGroup = userGroupRepository.save(lastUserGroup);
        return newUserGroup;
    }

    @Override
    public void deleteById(Long userGroupId) {
        userGroupRepository.deleteById(userGroupId);
    }

    @Override
    public void deleteAll() {
        userGroupRepository.deleteAll();
    }




}
