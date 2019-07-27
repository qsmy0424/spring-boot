package com.qsmy.springboot.controller;

import com.qsmy.springboot.bean.User;
import com.qsmy.springboot.repository.UserRepository;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qsmy
 * @date 2019-03-26 19:38
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * RequiresRoles 是所需要角色 包含 AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含 AMD 和 OR 两种
     */
    @RequiresRoles(value = {"admin", "test"}, logical = Logical.OR)
    // @RequiresPermissions(value = {"user:list", "user:query"}, logical = Logical.OR)
    @GetMapping("/query")
    public String query() {
        return "query---";
    }

    @GetMapping("/find")
    public String find() {
        return "find---";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        user = userRepository.save(user);
        return user;
    }
}
