package ga.lytestech.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

public class MainActivity extends AppCompatActivity {
    EditText movieTitle, movieDesc;
    Button bSave;
    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aq = new AQuery(this);

        movieTitle = (EditText) findViewById(R.id.editText);
        movieDesc = (EditText) findViewById(R.id.editText2);
        bSave = (Button) findViewById(R.id.button);



        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMovie();
            }
        });
    }

    public void saveMovie(){
        String movie_title = movieTitle.getText().toString();
        String movie_desc = movieDesc.getText().toString();


        String url = "http://lytestech.ga/api/lytes/save_movie";
        url += "?movie_title=" + movie_title  + "&movie_desc=" + movie_desc;
        aq.ajax(url, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response, AjaxStatus status) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }
        });

        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}
