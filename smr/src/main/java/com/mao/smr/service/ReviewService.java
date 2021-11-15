package com.mao.smr.service;

import com.mao.smr.dao.ReviewDAO;
import com.mao.smr.entity.Movie;
import com.mao.smr.entity.Review;
import com.mao.smr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewDAO reviewDAO;
    @Autowired
    MovieService movieService;
    @Autowired
    UserService userService;

    public List<Review> list(){
        Sort sortByIDDescending = new Sort(Sort.Direction.DESC, "id");
        return reviewDAO.findAll(sortByIDDescending);
    }

    public void addReview(Review review){
        reviewDAO.save(review);
    }

    public void deleteByID(int id){
        reviewDAO.deleteById(id);
    }

    public List<Review> listByMovie(int mID){
        Movie movie = movieService.getById(mID);
        return reviewDAO.findAllByMovie(movie);
    }

    public List<Review> listByUser(int uID){
        User user = userService.getByID(uID);
        return reviewDAO.findAllByUser(user);
    }

}
