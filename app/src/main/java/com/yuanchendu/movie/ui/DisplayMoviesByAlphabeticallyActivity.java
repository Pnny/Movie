package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.adapter.MovieAdapter;
import com.yuanchendu.movie.bean.MovieBean;

import java.util.ArrayList;

public class DisplayMoviesByAlphabeticallyActivity extends AppCompatActivity {

    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private RecyclerView list;
    private ArrayList<MovieBean> movieBeans = new ArrayList<>();
    private MovieAdapter adapter = null;
    private String[] movieName = new String[app.getMovieBeens().size()];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies_by_alphabetically);
        list = (RecyclerView)findViewById(R.id.list);

        initData();
        adapter = new MovieAdapter(movieBeans);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        list.setAdapter(adapter);
    }

    public void initData(){
        movieBeans.clear();
//        for (MovieBean movieBean : app.getMovieBeens()){
//            movieBeans.add(movieBean);
//        }
        for (int i = 0;i < app.getMovieBeens().size();i++){
            movieName[i] = app.getMovieBeens().get(i).getName();
            Log.d("movieName",movieName[i]);
        }

//        movieBeans.clear();
        sort(movieName);

        for (int i = 0; i < movieName.length ;i++){
            for (int j = 0;j < app.getMovieBeens().size();j++){
                MovieBean bean = app.getMovieBeens().get(j);
                String temp = bean.getName();
                if (temp.equals(movieName[i])){
                    movieBeans.add(bean);
                    Log.d("1","add");
                }
            }
        }


    }

    public int compare(String s1,String s2){
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int index = 0, len1 = arr1.length, len2 = arr2.length;
        int len = len1 < len2 ? len1 : len2;
        while (index < len) {
            char c1 = arr1[index], c2 = arr2[index];
            char c1_ = (char) (c1 >= 'a' ? c1 - ('a' - 'A') : c1);
            char c2_ = (char) (c2 >= 'a' ? c2 - ('a' - 'A') : c2);
            if (c1_ == c2_) {
                if (c1 != c2)
                    return c1 - c2;
            } else
                return c1_ - c2_;
            index++;
        }
        if (len1 == len2)
            return 0;
        else if (len1 > len2)
            return arr1[len];
        else
            return -arr2[len];
    }

    public void sort(String[] strings){
        String temp;
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                if (compare(strings[j], strings[j + 1]) > 0) {
                    temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }
    }
}
