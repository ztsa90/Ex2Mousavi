package org.example.ex2Mousavi.repository;

import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.model.UserGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserGroupRepository extends PagingAndSortingRepository<UserGroup,Long> {
    //many to one (userGroup 2 user)
    //many to one (userGroup 2 group)
   // List<UserGroup> findUserGroupByByUserAndGroup(User user, Group group);
    List<UserGroup>findUserGroupByUserAndGroupId(Long userId, Long groupId);
}
