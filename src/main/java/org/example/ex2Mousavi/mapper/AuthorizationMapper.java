package org.example.ex2Mousavi.mapper;

import org.example.ex2Mousavi.dto.AuthorizationDTO;

import org.example.ex2Mousavi.model.Authorization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorizationMapper {
    Authorization toEntity(AuthorizationDTO authorizationDTO);

    AuthorizationDTO toDTO(Authorization authorization);

    List<Authorization> toEntities(List<AuthorizationDTO> authorizationDTOs);

    List<AuthorizationDTO> toDTOs(List<Authorization> authorizations);

}
