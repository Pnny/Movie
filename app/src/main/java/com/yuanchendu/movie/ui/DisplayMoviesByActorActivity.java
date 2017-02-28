package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.adapter.MovieAdapter;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

public class DisplayMoviesByActorActivity extends AppCompatActivity {


    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private RecyclerView list;
    private Button submit;
    private EditText actorName;
    private String actorNameString;
    private ArrayList<MovieBean> movieBeans = new ArrayList<>();
    private MovieAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies_by_actor);
        list = (RecyclerView)findViewById(R.id.list);
        submit = (Button)findViewById(R.id.submit);
        actorName = (EditText)findViewById(R.id.condition_name);

        initData();
        adapter = new MovieAdapter(movieBeans);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        list.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actorName.getText().toString().equals("")){
                    initData();
                    adapter.notifyDataSetChanged();
                }else{
                    movieBeans.clear();
                    actorNameString = actorName.getText().toString();
                    for (int i =0;i  <app.getMovieBeens().size();i++)
                    {
                        MovieBean bean = app.getMovieBeens().get(i);
                        String str = bean.getCast();
                        if (str.indexOf(actorNameString) != -1){
                            movieBeans.add(bean);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
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
