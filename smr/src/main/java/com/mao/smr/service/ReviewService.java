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

    /**
     * list all the reviews in the database by id with a descending order
     */
    public List<Review> list(){
        Sort sortByIDDescending = new Sort(Sort.Direction.DESC, "id");
        return reviewDAO.findAll(sortByIDDescending);
    }

    /**
     * add a new review into the database
     */
    public void addReview(Review review){
        reviewDAO.save(review);
    }

    /**
     * delete a review in the database, with the help of front end check, only administrator can do this
     */
    public void deleteByID(int id){
        reviewDAO.deleteById(id);
    }

    /**
     * list all the reviews on a certain movie
     */
    public List<Review> listByMovie(int mID){
        Movie movie = movieService.getById(mID);
        return reviewDAO.findAllByMovie(movie);
    }

    /**
     * list all the reviews written by a certain user
     */
    public List<Review> listByUserName(String username){
        User user = userService.getByName(username);
        return reviewDAO.findAllByUser(user);
    }

}
