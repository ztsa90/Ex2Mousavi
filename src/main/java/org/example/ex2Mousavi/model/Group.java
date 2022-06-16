package org.example.ex2Mousavi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_groups")
@Setter
@Getter

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;
    @CreatedDate
    private Date createDate;
    @CreatedBy
    private String createBy;
    @CreatedDate
    private Date updateDate;
    @CreatedBy
    private String updateBy;

}