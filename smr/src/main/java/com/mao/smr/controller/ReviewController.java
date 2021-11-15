package com.mao.smr.controller;

import com.mao.smr.entity.Review;
import com.mao.smr.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/reviews/users/{uid}")
    public List<Review> listByUser(@PathVariable("uid") int uid) throws Exception{
        if(0 != uid){
            return reviewService.listByUser(uid);
        }else {
            return null;
        }
    }

    @GetMapping("/api/reviews/movies/{mid}")
    public List<Review> listByMovie(@PathVariable("mid") int mid) throws Exception{
        if(0 != mid){
            return reviewService.listByMovie(mid);
        }else {
            return null;
        }
    }
}
