package com.mao.smr.dao;

import com.mao.smr.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    //only use default functions
}
