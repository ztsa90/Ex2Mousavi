package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.User;

import java.util.List;

public interface IUserService {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    User update(Long id);

    void deleteById(Long id);

    void deleteAll();
}
