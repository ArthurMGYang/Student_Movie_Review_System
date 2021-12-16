package com.mao.smr.service;

import com.mao.smr.dao.CategoryDAO;
import com.mao.smr.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * the Service class contains a related DAO object
 * and use the methods in the DAO interface to achieve purpose
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    /**
     * find all the categories
     * and sort them by id with a descending order
     */
    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    /**
     * get a certain category information with a certain category id
     */
    public Category get(int id){
        Category category = categoryDAO.findById(id).orElse(null);
        return category;
    }
}
