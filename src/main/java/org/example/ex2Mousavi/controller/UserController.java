package org.example.ex2Mousavi.controller;

import org.example.ex2Mousavi.dto.GroupDTO;
import org.example.ex2Mousavi.dto.UserDTO;
import org.example.ex2Mousavi.mapper.UserMapper;
import org.example.ex2Mousavi.model.Group;
import org.example.ex2Mousavi.model.User;
import org.example.ex2Mousavi.service.IUserService;
import org.example.ex2Mousavi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    IUserService userService;
    UserMapper userMapper;

    public UserController(IUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "/save")
    public ResponseEntity <UserDTO> save(@RequestBody UserDTO userDTO)
    {
        User user=userMapper.toEntity(userDTO);
        UserDTO userDTO1=userMapper.toDTO(userService.save(user));
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity <UserDTO> update(@RequestBody UserDTO userDTO)
    {
        User user=userMapper.toEntity(userDTO);
        UserDTO userDTO1=userMapper.toDTO(userService.update(user.getId()));
        return new ResponseEntity<>(userDTO1, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteById/{userId}")

    public void deleteById(@PathVariable Long userId) {

       userService.deleteById(userId);
    }
    @GetMapping(value = "/getById/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long userId) {

        User user =  userService.getById(userId);
        UserDTO userDTO = userMapper.toDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {

        List<User> users = userService.getAll();
        List<UserDTO> userDTOs = userMapper.toDTOs(users);
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }


}
