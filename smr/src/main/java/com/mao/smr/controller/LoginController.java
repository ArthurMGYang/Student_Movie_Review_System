package com.mao.smr.controller;

import com.mao.smr.result.Result;
import com.mao.smr.result.ResultFactory;
import com.mao.smr.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.mao.smr.entity.User;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * used to check the information input by the users when they log in
     */
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);//let the webpages remember the user info after the user log in
        try {
            subject.login(usernamePasswordToken);
            User user = userService.getByName(username);
            return ResultFactory.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("wrong password");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("account not exist");
        }
    }


    /**
     * used to register a new user
     * @param user the user instance is created with the information input by the user in the registration page
     */
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);//make sure the username is unique
        if (exist) {
            String message = "this username has already been taken";
            return ResultFactory.buildFailResult(message);
        }

        // generate the salt
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // hash algorithm iterations
        int times = 2;
        // the password after encryption
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // save the user encrypted information
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @ResponseBody
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "successfully log out";
        return ResultFactory.buildSuccessResult(message);
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "Identity authentication succeeded";
    }


}



