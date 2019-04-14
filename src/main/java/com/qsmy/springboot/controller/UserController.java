package com.qsmy.springboot.controller;

import com.qsmy.springboot.bean.User;
import com.qsmy.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author qsmy
 * @desctiption TODO
 * @Date 2019-03-26 19:38
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        user = userRepository.save(user);
        return user;
    }
}
