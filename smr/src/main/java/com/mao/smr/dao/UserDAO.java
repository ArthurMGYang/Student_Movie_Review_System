package com.mao.smr.dao;

import com.mao.smr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * the DAO of User class,mainly used to interact with the data in User table
 * three methods are added to
 * find users by ID
 * find users by username
 * and get users with the input username and password (used to log in)
 */
public interface UserDAO extends JpaRepository<User,Integer> {
    User findById(int id);
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
