package com.mao.smr.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "review")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "mID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "uID")
    private User user;

    int rank1;
    int rank2;
    String content;
    String watchDate;
    String watchPlace;

    public String getWatchDate() {
        return watchDate;
    }

    public void setWatchDate(String watchDate) {
        this.watchDate = watchDate;
    }

    public String getWatchPlace() {
        return watchPlace;
    }

    public void setWatchPlace(String watchPlace) {
        this.watchPlace = watchPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRank1() {
        return rank1;
    }

    public void setRank1(int rank1) {
        this.rank1 = rank1;
    }

    public int getRank2() {
        return rank2;
    }

    public void setRank2(int rank2) {
        this.rank2 = rank2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
