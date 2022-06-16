package org.example.ex2Mousavi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserGroupDTO {
    //Many 2 One User to userGroup
    //Many 2 One group to userGroup
    UserDTO user;
    UserDTO group;

    public UserGroupDTO(UserDTO user, UserDTO group, Boolean active) {
        this.user = user;
        this.group = group;
        this.active = active;
    }


    @ApiModelProperty(required = true, hidden = false)
    private Boolean active;

}
