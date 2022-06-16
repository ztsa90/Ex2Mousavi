package org.example.ex2Mousavi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.example.ex2Mousavi.model.EPermission;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Setter
@Getter
public class AuthorizationDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String source;
    private EPermission ePermission;

    //many to one authorization to group
    //many to one authorization to user
    private UserDTO user;
    private GroupDTO group;
    private UserGroupDTO userGroup;
    }
