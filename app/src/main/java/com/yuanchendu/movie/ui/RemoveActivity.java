package com.yuanchendu.movie.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuanchendu.movie.App;
import com.yuanchendu.movie.R;
import com.yuanchendu.movie.bean.MovieBean;

public class RemoveActivity extends AppCompatActivity {

    private Context context = App.getInstance();
    private App app = (App)context.getApplicationContext();
    private EditText name;
    private Button submit;
    private String nameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        name = (EditText)findViewById(R.id.remove_name);
        submit = (Button)findViewById(R.id.remove_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = name.getText().toString();
                for (int i = 0;i < app.getMovieBeens().size();i++){
                    MovieBean movie = app.getMovieBeens().get(i);
                    if ((movie.getName()).equals(nameString)){
                        app.getMovieBeens().remove(movie);
                    }
                }
                Toast.makeText(RemoveActivity.this, "success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
