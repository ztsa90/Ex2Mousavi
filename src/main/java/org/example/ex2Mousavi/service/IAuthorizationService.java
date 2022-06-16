package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Authorization;

import java.util.List;

public interface IAuthorizationService {
    Authorization save(Authorization authorization, Long userId, Long groupId,Long userGroupId);

    Authorization update(Authorization authorization);

    Authorization getById(Long id);

    List<Authorization> getAll();

    void deleteById(Long id);

    void deleteAll();
    List<Authorization> findAuthorizationByGroupIdAndUserId(Long groupId, Long userId);
    //List<Authorization> findAuthorizationByUserIdAndUserGroupId(Long userId, Long userGroupId);
}
