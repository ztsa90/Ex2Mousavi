package org.example.ex2Mousavi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//considering as child
@Entity
@Table(name = "tbl_authorization")

public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_id")
    private Long id;


    @Column(name = "authorizationSource")
    private String source;

    @Enumerated(EnumType.STRING)
    private  EPermission ePermission;

    public EPermission getPermission() {
        return ePermission;
    }

    public void setePermission(EPermission ePermission) {
        this.ePermission = ePermission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EPermission getePermission() {
        return ePermission;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "id_user_group")
    private UserGroup userGroup;

}
