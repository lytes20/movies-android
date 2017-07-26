package ga.lytestech.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gideon_bamuleseyo on 7/17/17.
 */

public class MyCustomAdapter extends BaseAdapter {

    String [] movieTitles;
    String [] movieDesc;
    Context context;
    int [] movieImages;

    public MyCustomAdapter(Context a, String[] leMovieTitles, int[] leMovieImages, String [] leMovieDesc) {
        movieTitles = leMovieTitles;
        context = a;
        movieImages = leMovieImages;
        movieDesc = leMovieDesc;
    }

    @Override
    public int getCount() {
        return movieTitles.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.single_item, null, true);
        TextView  txtTitle = (TextView) rowView.findViewById(R.id.tMovie);
        TextView txtDesc = (TextView) rowView.findViewById(R.id.tMovieDesc);
        ImageView mImage =  (ImageView)rowView.findViewById(R.id.movieImage);

        txtTitle.setText(movieTitles[i]);
        txtDesc.setText(movieDesc[i]);
        mImage.setImageResource(movieImages[i]);
        return rowView;
    }
}
