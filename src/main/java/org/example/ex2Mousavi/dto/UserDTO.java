package org.example.ex2Mousavi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String firstName;

    @ApiModelProperty(required = true,hidden = false)
    private String lastName;
    @ApiModelProperty(required = true,hidden = false)
    private String username;

    @ApiModelProperty(required = false,hidden = true)
    private String password;


}
