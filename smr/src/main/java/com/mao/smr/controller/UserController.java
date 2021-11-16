package com.mao.smr.controller;

import com.mao.smr.entity.User;
import com.mao.smr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users/{username}")
    public User getUserByName(@PathVariable("username") String username) throws Exception{
        return userService.getByName(username);
    }
}
