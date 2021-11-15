package com.mao.smr.dao;

import com.mao.smr.entity.Movie;
import com.mao.smr.entity.Review;
import com.mao.smr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer> {

    List<Review> findAllByMovie(Movie movie);
    List<Review> findAllByUser(User user);
}
