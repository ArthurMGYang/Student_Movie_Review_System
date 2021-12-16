package com.mao.smr.service;

import com.mao.smr.dao.UserDAO;
import com.mao.smr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    /**
     * this is used to check if there is a user with a username already in the database
     * used in the registration progress to make sure every user have different username
     */
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByID(int id){
        return userDAO.findById(id);
    }
    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }


    /**
     * add a new user into the database, in the front end, this is the registration progress
     */
    public void add(User user) {
        userDAO.save(user);
    }
}
