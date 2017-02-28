package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.bean.MovieBean;

public class AddActivity extends AppCompatActivity {

    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();

    private MovieBean movie;

    private Button submit;

    private EditText description;
    private EditText name;
    private EditText rate;
    private EditText cast;
    private Spinner spinner;

    private AppCompatCheckBox action;
    private AppCompatCheckBox romance;
    private AppCompatCheckBox comedy;
    private AppCompatCheckBox drama;
    private AppCompatCheckBox documentary;
    private AppCompatCheckBox anime;

    private String descriptionString,nameString,rateString,castString,hasSeenString,genreString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                movie = new MovieBean(castString,genreString,nameString,rateString,hasSeenString,descriptionString);
                app.getMovieBeens().add(movie);
                Toast.makeText(AddActivity.this, "success", Toast.LENGTH_SHORT).show();
                Log.d("movie",movie.toString());
                finish();
            }
        });
    }

    public void initView(){
        submit = (Button)findViewById(R.id.add_submit);
        description = (EditText)findViewById(R.id.et_add_description);
        name = (EditText)findViewById(R.id.et_add_name);
        rate = (EditText)findViewById(R.id.et_add_rate);
        cast = (EditText)findViewById(R.id.et_add_cast);
        action = (AppCompatCheckBox)findViewById(R.id.actionCheckBox);
        romance = (AppCompatCheckBox)findViewById(R.id.romanceCheckBox);
        comedy = (AppCompatCheckBox)findViewById(R.id.comedyCheckBox);
        drama = (AppCompatCheckBox)findViewById(R.id.dramaCheckBox);
        documentary = (AppCompatCheckBox)findViewById(R.id.documentaryCheckBox);
        anime = (AppCompatCheckBox)findViewById(R.id.animeCheckBox);
        spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] result = getResources().getStringArray(R.array.trueOrFalse);
                hasSeenString = result[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                hasSeenString = "true";
            }
        });
    }

    public void initData(){

        genreString = "";
        if (action.isChecked()){
            genreString += " Action";
        }
        if (romance.isChecked()){
            genreString += " Romance";
        }
        if (comedy.isChecked()){
            genreString += " Comedy";
        }
        if (drama.isChecked()){
            genreString += " Drama";
        }
        if (documentary.isChecked()){
            genreString += " Documentary";
        }
        if (anime.isChecked()){
            genreString += " Anime";
        }
        Log.d("genreString",genreString);

        nameString = name.getText().toString();
        castString = cast.getText().toString();
        rateString = rate.getText().toString();
        descriptionString = description.getText().toString();

    }

}
