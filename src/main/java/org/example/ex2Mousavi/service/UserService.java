package org.example.ex2Mousavi.service;

import org.example.ex2Mousavi.model.Authorization;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("NO ID");
        }
        return optionalUser.get();

    }

    @Override
    public User update(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("NO ID");
        }
        User lastUser= optionalUser.get();
        Long lastId=id;
        Long newId= lastUser.getId();
        String newFirstName=lastUser.getFirstName();
        String newLastName= lastUser.getLastName();
        String newUsername=lastUser.getUsername();
        String newPassword=lastUser.getPassword();
        lastUser.setUsername(newUsername);
        lastUser.setLastName(newLastName);
        lastUser.setFirstName(newFirstName);
        lastUser.setPassword(newPassword);
         User newUser=userRepository.save(lastUser);
        return newUser;
    }

    @Override
    public List<User> getAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

         userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository. deleteAll();
    }
}
