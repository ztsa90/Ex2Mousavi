package org.example.ex2Mousavi.mapper;


import org.example.ex2Mousavi.dto.GroupDTO;
import org.example.ex2Mousavi.dto.UserGroupDTO;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.UserGroup;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserGroupMapper {
    UserGroup toEntity(UserGroupDTO userGroupDTO);

    UserGroupDTO toDTO(UserGroup userGroup);

    List<UserGroup> toEntities(List<UserGroupDTO> userGroupDTOs);

    List<UserGroupDTO> toDTOs(List<UserGroup> userGroups);

}
