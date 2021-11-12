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

    public List<Movie> list(){
        Sort sortByIDDescending = new Sort(Sort.Direction.DESC, "id");
        return movieDAO.findAll(sortByIDDescending);
    }

    public void addOrUpdate(Movie movie){
        movieDAO.save(movie);
    }

    public void deleteById(int id){
        movieDAO.deleteById(id);
    }

    public List<Movie> listByCategory(int categoryID){
        Category category = categoryService.get(categoryID);
        return movieDAO.findAllByCategory(category);
    }

    public Movie getById(int id){
        Movie movie = movieDAO.findById(id).orElse(null);
        return movie;
    }

    public List<Movie> Search(String keywords){
        return movieDAO.findAllByTitleLikeOrDirector('%' + keywords + '%', '%' + keywords + '%');
    }
}
