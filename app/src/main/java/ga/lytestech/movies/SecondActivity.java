package ga.lytestech.movies;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by gideon_bamuleseyo on 7/17/17.
 */

public class SecondActivity extends AppCompatActivity {

    ListView myList;
    String [] mMovieTitles;
    String [] mMovieDesc;
    int [] mMovieImages = {R.drawable.wonder_woman, R.drawable.pirates};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Resources res = getResources();
        mMovieTitles = res.getStringArray(R.array.movie_titles);


        mMovieDesc = res.getStringArray(R.array.movie_description);

        myList = (ListView) findViewById(R.id.list);

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this, mMovieTitles, mMovieImages, mMovieDesc);
        myList.setAdapter(myCustomAdapter);

    }
}
