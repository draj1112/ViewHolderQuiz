package sidespell.tech.viewholderquiz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import sidespell.tech.viewholderquiz.MainActivity;
import sidespell.tech.viewholderquiz.activities.DetailsActivity;
import sidespell.tech.viewholderquiz.adapters.MovieAdapter;
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Movie> movieList = MovieController.getMovieList();

        View view =  inflater.inflate(R.layout.fragment_gridview, container, false);
        mGridView = (GridView) view.findViewById(R.id.gridView);
        mTextView = (TextView) view.findViewById(android.R.id.empty);

        MovieAdapter adapter = new MovieAdapter(inflater.getContext(), R.layout.movie_item, movieList);
        mGridView.setAdapter(adapter);

        if (movieList == null) {
            mTextView.setCursorVisible(true);
        }
        else {
            mTextView.setCursorVisible(false);
        }

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getParentFragment().getContext(), DetailsActivity.class);
                intent.putExtra("pos", position);

                startActivity(intent);
            }
        });
        return view;
    }

}
