package org.example.ex2Mousavi.model;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "tbl_usergroups")

public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="usegroup_id")
    private Long Id;

    @Column(name="usergroup_active")
    private Boolean active;

    @Column(name="usergroup_creatd_date")
    @CreatedDate
    private Date createDate;

    @Column(name="usergroup_creatdBy")
    @CreatedBy
    private String createBy;

    @Column(name="usergroup_update_date")
    @CreatedDate
    private Date updateDate;

    @Column(name="usergroup_updateby")
    @CreatedBy
    private String updateBy;

    //many 2 one userGroup to user
    //many 2 one userGroup to group
    @ManyToOne
    private User user;
    @ManyToOne
    private Group group;

}
