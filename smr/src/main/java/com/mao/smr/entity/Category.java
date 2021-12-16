package com.mao.smr.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * all the entities are the classes represent to the tables in the database
 * the all have the attribute the same as the tables, and they have getters and setters for those attributes
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
