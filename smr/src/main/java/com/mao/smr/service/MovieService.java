package com.mao.smr.service;

import com.mao.smr.dao.MovieDAO;
import com.mao.smr.entity.Category;
import com.mao.smr.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieDAO movieDAO;
    @Autowired
    CategoryService categoryService;

    /**
     * list all the movies by id with a descending order
     */
    public List<Movie> list(){
        Sort sortByIDDescending = new Sort(Sort.Direction.DESC, "id");
        return movieDAO.findAll(sortByIDDescending);
    }

    /**
     * add a new movie into the database
     * @param movie the movie to be added
     */
    public void addOrUpdate(Movie movie){
        movieDAO.save(movie);
    }

    /**
     * delete a movie in the database by the id
     */
    public void deleteById(int id){
        movieDAO.deleteById(id);
    }

    /**
     * list the movies by the category
     * used when click the category in the front end, show the movies of the that category
     */
    public List<Movie> listByCategory(int categoryID){
        Category category = categoryService.get(categoryID);
        return movieDAO.findAllByCategory(category);
    }

    public Movie getById(int id){
        Movie movie = movieDAO.findById(id).orElse(null);
        return movie;
    }

    /**
     * find a movie by the keyword, the keyword can be a part of the tile or the director
     * @param keywords the keyword input by user
     * @return the movie contains the keyword
     */
    public List<Movie> Search(String keywords){
        return movieDAO.findAllByTitleLikeOrDirector('%' + keywords + '%', '%' + keywords + '%');
    }
}
