package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.adapter.MovieAdapter;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

public class ShowAllActivity extends AppCompatActivity {

    private RecyclerView list;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MovieAdapter adapter = null;
    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private ArrayList<MovieBean> movieBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swiperefresh);
        list = (RecyclerView)findViewById(R.id.list);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                getData();
            }
        });

        movieBeans = app.getMovieBeens();
        adapter = new MovieAdapter(movieBeans);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }

    public void getData(){
        movieBeans = app.getMovieBeens();
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}
