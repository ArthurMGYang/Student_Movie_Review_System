package com.mao.smr.controller;

import com.mao.smr.entity.Movie;
import com.mao.smr.result.Result;
import com.mao.smr.result.ResultFactory;
import com.mao.smr.service.MovieService;
import com.mao.smr.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * the controller classes are related to front end application operations
 * this controller mainly controls the operations in the library page in the front end
 */
@RestController
public class LibraryController {
    @Autowired
    MovieService movieService;

    /**
     * list all the movies in the link below
     * the front end page will get throw there to get the information
     * and then show them in the way with the front end vue code
     */
    @GetMapping("/api/movies")
    public List<Movie> list() throws Exception{
        return movieService.list();
    }

    /**
     * when add a movie in the front end page
     * it post the information in the link and then, this method will add it into the database
     */
    @PostMapping("/api/movies")
    public Movie addOrUpdate(@RequestBody Movie movie) throws Exception{
        movieService.addOrUpdate(movie);
        return movie;
    }

    @PostMapping("/api/movie/delete")
    public void delete(@RequestBody Movie movie) throws Exception{
        movieService.deleteById(movie.getId());
    }

    @GetMapping("/api/categories/{categoryID}/movies")
    public List<Movie> listByCategory(@PathVariable("categoryID") int categoryID) throws Exception{
        if(0 != categoryID){
            return movieService.listByCategory(categoryID);
        }else{
            return list();
        }
    }

    @GetMapping("/api/movies/{id}")
    public Movie getMovieById(@PathVariable("id") int id) throws Exception{
        if(0 != id){
            return movieService.getById(id);
        }else{
            return null;
        }
    }

    @PostMapping("/api/search")
    public List<Movie> searchResult(@RequestParam("keywords") String keywords) {
        if ("".equals(keywords)) {
            return movieService.list();
        } else {
            return movieService.Search(keywords);
        }
    }

    /**
     * when adding a movie, it needs an image as the cover
     * this method used to store the cover images into the path given below
     */
    @CrossOrigin
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "/Users/yangmao/study/Glasgow_Final_project/workspace/student_movie_review/src/assets/covers";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
