package sidespell.tech.viewholderquiz.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sidespell.tech.viewholderquiz.adapters.MovieAdapter;
import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.controllers.MovieController;
import sidespell.tech.viewholderquiz.model.Movie;

/**
 * A placeholder fragment containing a {@link android.widget.ListView}.
 */
public class ListViewFragment extends Fragment {

    private ListView mListView;
    private TextView mTextView;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Movie> movieList= MovieController.getMovieList();

        View view =  inflater.inflate(R.layout.fragment_listview, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);
        mTextView = (TextView) view.findViewById(android.R.id.empty);

        MovieAdapter adapter = new MovieAdapter(inflater.getContext(), R.layout.movie_item, movieList);
        mListView.setAdapter(adapter);

        if (movieList == null) {
            mTextView.setCursorVisible(true);
        }
        else {
            mTextView.setCursorVisible(false);
        }
        return view;
    }
}
