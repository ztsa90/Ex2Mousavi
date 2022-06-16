package org.example.ex2Mousavi.repository;

import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorizationRepository extends PagingAndSortingRepository<Authorization, Long> {

    List<Authorization> findAuthorizationByGroupIdAndUserId(Long groupId, Long userId);
    //List<Authorization> findAuthorizationByUserIdAndUserGroupId(Long userId, Long userGroupId);
}
