package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.adapter.MovieAdapter;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

public class DisplayMoviesByGenreActivity extends AppCompatActivity {

    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private RecyclerView list;
    private Button submit;
    private Spinner spinner;
    private String genreString;
    private ArrayList<MovieBean> movieBeans = new ArrayList<>();
    private MovieAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies_by_genre);

        list = (RecyclerView)findViewById(R.id.list);
        submit = (Button)findViewById(R.id.submit);
        spinner = (Spinner)findViewById(R.id.spinner);

        initData();
        adapter = new MovieAdapter(movieBeans);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        list.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                initData();
                String genre[] = getResources().getStringArray(R.array.genre);
                genreString = genre[position];

                movieBeans.clear();
                for (int i =0;i  <app.getMovieBeens().size();i++)
                {
                    MovieBean bean = app.getMovieBeens().get(i);
                    String str = bean.getGenre();
                    if (str.indexOf(genreString) != -1){
                        movieBeans.add(bean);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void initData(){
        movieBeans.clear();
        for (MovieBean movieBean : app.getMovieBeens()){
            movieBeans.add(movieBean);
        }
    }
}
