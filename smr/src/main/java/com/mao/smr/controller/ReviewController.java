package com.mao.smr.controller;

import com.mao.smr.entity.Movie;
import com.mao.smr.entity.Review;
import com.mao.smr.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * this controller used to control the operations in review pages
 * although some methods are different, it has the similar logic as the Library Controller
 */
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("api/reviews")
    public List<Review> list() throws Exception{
        return reviewService.list();
    }

    @PostMapping("api/reviews")
    public Review addOrUpdate(@RequestBody Review review) throws Exception{
        reviewService.addReview(review);
        return review;
    }

    @GetMapping("/api/reviews/users/{username}")
    public List<Review> listByUser(@PathVariable("username") String username) throws Exception{
        return reviewService.listByUserName(username);
    }

    @GetMapping("/api/reviews/movies/{mid}")
    public List<Review> listByMovie(@PathVariable("mid") int mid) throws Exception{
        if(0 != mid){
            return reviewService.listByMovie(mid);
        }else {
            return null;
        }
    }

    @PostMapping("/api/review/delete")
    public void delete(@RequestBody Review review) throws Exception{
        reviewService.deleteByID(review.getId());
    }
}
