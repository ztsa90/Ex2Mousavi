package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService implements IGroupService {
    GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

//    @Override
//    public Group findById(Long id) {
//        Group group=groupRepository.findById(id);
//        return group;
//    }

    @Override
    public Group getById(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            throw new NotFoundException("no id");
        }
        return optionalGroup.get();
    }

    @Override
    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }


    @Override
    public Group update(Group group) {
        Long lastId = group.getId();
        Optional<Group> optionalGroup = groupRepository.findById(lastId);
        if (optionalGroup.isEmpty()) {
            throw new NotFoundException("no id");
        }

        Group lastGroup = optionalGroup.get();

        String newName = group.getName();
        lastGroup.setName(newName);
        Boolean newActive = group.getActive();
        lastGroup.setActive(newActive);
        Group newGroup = groupRepository.save(lastGroup);
        return newGroup;
    }


    @Override
    public void deleteAll() {
        groupRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }



}
