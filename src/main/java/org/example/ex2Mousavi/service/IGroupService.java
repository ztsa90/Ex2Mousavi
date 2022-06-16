package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Group;

import java.util.List;
import java.util.Optional;

public interface IGroupService {
    Group save(Group group);
    //این خطا میده همش
//    Group findById(Long groupId);


    Group getById(Long id);

    List<Group> getAll();

    Group update(Group group);

    void deleteAll();

    void deleteById(Long id);

}
