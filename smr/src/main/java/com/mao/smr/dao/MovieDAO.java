package com.mao.smr.dao;

import com.mao.smr.entity.Category;
import com.mao.smr.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * the DAO of Movie class,mainly used to interact with the data in Movie table
 * except for the default methods, because this project need the movie list by category
 * and users may search the movie by title or director
 * tow methods are added
 */
public interface MovieDAO extends JpaRepository<Movie,Integer> {
    List<Movie> findAllByCategory(Category category);
    List<Movie> findAllByTitleLikeOrDirector(String keyword1, String keyword2);
}
