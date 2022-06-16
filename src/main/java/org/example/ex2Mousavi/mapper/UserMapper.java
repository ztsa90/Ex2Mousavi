package org.example.ex2Mousavi.mapper;


import org.example.ex2Mousavi.dto.UserDTO;
import org.example.ex2Mousavi.model.User;


import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")

public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);

    List<User>toEntities(List<UserDTO>userDTOs);
    List<UserDTO>toDTOs(List<User>users);

}
