package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.UserGroup;

import java.util.List;

public interface IUserGroupService  {
    UserGroup save(UserGroup userGroup,Long UserId,Long GroupId);

    UserGroup getById(Long userGroupId);

    List<UserGroup> getAll();

    UserGroup update(UserGroup userGroup);

    void deleteById(Long id);

    void deleteAll();

    List<UserGroup> findUserGroupByUserAndGroupId(Long userId, Long groupId);
}

