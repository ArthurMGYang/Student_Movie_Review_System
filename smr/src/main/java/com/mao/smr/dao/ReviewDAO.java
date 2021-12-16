package com.mao.smr.dao;

import com.mao.smr.entity.Movie;
import com.mao.smr.entity.Review;
import com.mao.smr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * the DAO of Review class,mainly used to interact with the data in Review table
 * except for the default methods
 * the reviews will be listed by movies or listed by users, so two methods are added
 */
public interface ReviewDAO extends JpaRepository<Review,Integer> {

    List<Review> findAllByMovie(Movie movie);
    List<Review> findAllByUser(User user);
}
