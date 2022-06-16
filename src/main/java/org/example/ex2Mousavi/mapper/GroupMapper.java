package org.example.ex2Mousavi.mapper;

import org.example.ex2Mousavi.dto.GroupDTO;
import org.example.ex2Mousavi.model.Group;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")

public interface GroupMapper {
    Group toEntity(GroupDTO groupDTO);
    GroupDTO toDTO(Group group);

    List<Group>toEntities(List<GroupDTO>groupDTOs);
    List<GroupDTO>toDTOs(List<Group> groups);

}
