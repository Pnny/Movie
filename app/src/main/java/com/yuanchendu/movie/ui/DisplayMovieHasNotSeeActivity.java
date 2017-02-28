package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.adapter.MovieAdapter;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

public class DisplayMovieHasNotSeeActivity extends AppCompatActivity {

    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private RecyclerView list;
    private ArrayList<MovieBean> movieBeans = new ArrayList<>();
    private MovieAdapter adapter = null;
    private String hasSeenString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie_has_not_see);
        list = (RecyclerView)findViewById(R.id.list);

        for (int i = 0; i < app.getMovieBeens().size();i++){
            MovieBean bean = app.getMovieBeens().get(i);
            hasSeenString = bean.getHaveSeen();
            if (hasSeenString.equals("no")){
                movieBeans.add(bean);
            }
        }

        adapter = new MovieAdapter(movieBeans);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        list.setAdapter(adapter);
    }


}
