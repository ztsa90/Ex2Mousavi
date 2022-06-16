package org.example.ex2Mousavi.model;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


//considering as parent
@Entity
@Table(name = "tbl_users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean active;
    @CreatedDate
    private Date createDate;
    @CreatedBy
    private String createBy;
    @CreatedDate
    private Date updateDate;
    @CreatedBy
    private String updateBy;

     // @OneToOne
     // private Authorization authorization;

}
