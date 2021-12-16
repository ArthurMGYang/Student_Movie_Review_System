package com.mao.smr.dao;

import com.mao.smr.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * the DAO (Data Access Object) of Category class
 * mainly used to interact with the data in Category table
 * because this project only need the default functions of the JpaRespository
 * there are no methods inside
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
    //only use default functions
}
