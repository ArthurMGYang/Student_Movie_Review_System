package com.mao.smr.dao;

import com.mao.smr.entity.Category;
import com.mao.smr.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDAO extends JpaRepository<Movie,Integer> {
    List<Movie> findAllByCategory(Category category);
    List<Movie> findAllByTitleLikeOrDirector(String keyword1, String keyword2);
}
