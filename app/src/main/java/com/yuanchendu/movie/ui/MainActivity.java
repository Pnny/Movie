package com.yuanchendu.movie.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yuanchendu.movie.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button add,remove,quit,showAll;
    private Button displayMovieByAlphabetically;
    private Button displayMovieByNumber;
    private Button displayMovieByGenre;
    private Button displayMovieByActor;
    private Button displayMovieNoSee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnClickListener();
    }

    public void initView(){
        showAll = (Button)findViewById(R.id.showAll);
        add = (Button)findViewById(R.id.addMovie);
        remove = (Button)findViewById(R.id.removeMovie);
        quit = (Button)findViewById(R.id.quit);
        displayMovieByAlphabetically = (Button)findViewById(R.id.displayMoviesByAlphabetically);
        displayMovieByNumber = (Button)findViewById(R.id.displayMoviesByNumber);
        displayMovieByGenre = (Button)findViewById(R.id.displayMoviesByGenre);
        displayMovieByActor = (Button)findViewById(R.id.displayMoviesByActor);
        displayMovieNoSee = (Button)findViewById(R.id.displayMoviesNoSee);
    }

    public void setOnClickListener(){
        showAll.setOnClickListener(this);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        quit.setOnClickListener(this);
        displayMovieByAlphabetically.setOnClickListener(this);
        displayMovieNoSee.setOnClickListener(this);
        displayMovieByActor.setOnClickListener(this);
        displayMovieByNumber.setOnClickListener(this);
        displayMovieByGenre.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showAll:
                startActivity(new Intent(this,ShowAllActivity.class));
                break;
            case R.id.addMovie:
                startActivity(new Intent(this, AddActivity.class));
                break;
            case R.id.removeMovie:
                startActivity(new Intent(this,RemoveActivity.class));
                break;
            case R.id.displayMoviesByAlphabetically:
                startActivity(new Intent(this,DisplayMoviesByAlphabeticallyActivity.class));
                break;
            case R.id.displayMoviesByActor:
                startActivity(new Intent(this,DisplayMoviesByActorActivity.class));
                break;
            case R.id.displayMoviesByGenre:
                startActivity(new Intent(this,DisplayMoviesByGenreActivity.class));
                break;
            case R.id.displayMoviesByNumber:
                startActivity(new Intent(this,DisplayMoviesByNumberActivity.class));
                break;
            case R.id.displayMoviesNoSee:
                startActivity(new Intent(this,DisplayMovieHasNotSeeActivity.class));
                break;
            case R.id.quit:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("quit?");
                builder.setMessage("Are you sure you want to quit? - all your data will be lost");
                builder.setIcon(R.mipmap.icon);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();

                break;
        }
    }
}
