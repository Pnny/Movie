package com.yuanchendu.movie.bean;

/**
 * Created by Reims on 2016/11/29.
 */

public class MovieBean {

    private String name;
    private String rate;
    private String description;
    private String genre;
    private String haveSeen;
    private String cast;



    public MovieBean(String cast, String genre, String name, String rate, String haveSeen, String description) {
        this.cast = cast;
        this.genre = genre;
        this.name = name;
        this.rate = rate;
        this.haveSeen = haveSeen;
        this.description = description;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getHaveSeen() {
        return haveSeen;
    }

    public void setHaveSeen(String haveSeen) {
        this.haveSeen = haveSeen;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MovieBean{" +
                "cast='" + cast + '\'' +
                ", name='" + name + '\'' +
                ", rate='" + rate + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", haveSeen='" + haveSeen + '\'' +
                '}';
    }
}
