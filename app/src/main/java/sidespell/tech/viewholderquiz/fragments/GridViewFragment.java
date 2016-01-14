package sidespell.tech.viewholderquiz.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import sidespell.tech.viewholderquiz.MovieAdapter;
import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.controllers.MovieController;
import sidespell.tech.viewholderquiz.model.Movie;

/**
 * A placeholder fragment containing a {@link android.widget.GridView}.
 */
public class GridViewFragment extends Fragment {

    private GridView mGridView;
    private TextView mTextView;

    public static GridViewFragment newInstance() {
        return new GridViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Movie> movieList = MovieController.getMovieList();

        View view =  inflater.inflate(R.layout.fragment_gridview, container, false);
        mGridView = (GridView) view.findViewById(R.id.gridView);
        mTextView = (TextView) view.findViewById(android.R.id.empty);

        MovieAdapter adapter = new MovieAdapter(this, R.layout.movie_item, movieList);
        mGridView.setAdapter(adapter);

        if (movieList == null) {
            mTextView.setCursorVisible(true);
        }
        else {
            mTextView.setCursorVisible(false);
        }
        return view;
    }

}
