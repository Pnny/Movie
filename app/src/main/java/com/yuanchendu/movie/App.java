package com.yuanchendu.movie;

import android.app.Application;

import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

/**
 * Created by Reims on 2016/11/29.
 */

public class App extends Application {

    private ArrayList<MovieBean> movieBeens = new ArrayList<>();
    private static App instance;

    public static App getInstance() {
        if(instance == null){
            instance = new App();
            return instance;
        }else {
            return instance;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


        movieBeens.add(new MovieBean("Anne Hathaway, Jim Sturgess, Romola Garai","Romance","One Day","4.6","yes",
                "Love story between Emma and Dexter. They aren't quite sure they are in love, but continue to get in contact with each other on the same day every year for the next two decades, to check in on one another's lives."));
        movieBeens.add(new MovieBean("Zhou Dongyu, Ma Sichuan, Toby Lee","Romance Drama","Soul Mate","4.0","no",
                "Growth Story between Qiyue and Ansheng. They change life and live each other’s life."));
        movieBeens.add(new MovieBean("Daniel Radcliffe, Emma Watson, Rupert Grint","Adventure Family Fantasy","Harry Potter and the Philosopher’s Stone","4.2","yes",
                "Rescued from the outrageous neglect of his aunt and uncle, a young boy with a great destiny proves his worth while attending Hogwarts School of Witchcraft and Wizardry."));

    }

    public void initData(){
        movieBeens.clear();
        movieBeens.add(new MovieBean("Anne Hathaway, Jim Sturgess, Romola Garai","Romance","One Day","4.6","yes",
                "Love story between Emma and Dexter. They aren't quite sure they are in love, but continue to get in contact with each other on the same day every year for the next two decades, to check in on one another's lives."));
        movieBeens.add(new MovieBean("Zhou Dongyu, Ma Sichuan, Toby Lee","Romantic drama","Soul Mate","4.0","no",
                "Growth Story between Qiyue and Ansheng. They change life and live each other’s life."));
        movieBeens.add(new MovieBean("Daniel Radcliffe, Emma Watson, Rupert Grint","Adventure Family Fantasy","Harry Potter and the Philosopher’s Stone","4.2","yes",
                "Rescued from the outrageous neglect of his aunt and uncle, a young boy with a great destiny proves his worth while attending Hogwarts School of Witchcraft and Wizardry."));
    }

    public ArrayList<MovieBean> getMovieBeens() {
        return movieBeens;
    }

    public void setMovieBeens(ArrayList<MovieBean> movieBeens) {
        this.movieBeens = movieBeens;
    }

}
