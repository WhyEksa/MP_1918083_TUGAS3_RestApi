package com.wes.mp_1918083_tugas3_restapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.wes.mp_1918083_tugas3_restapi.recyclerview.adapters.MovieRecycleView;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.adapters.OnMovieListener;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.models.MovieModel;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.models.viewmodels.PopularMovieListViewModel;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    private PopularMovieListViewModel popularMovieListViewModel;
    private RecyclerView recyclerView;
    private MovieRecycleView recycleViewAdapter;

    private boolean isPopular = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.recycleView);

        popularMovieListViewModel = new ViewModelProvider(this).get(PopularMovieListViewModel.class);

        // data observer
        ObservasingAnyChangesPopularMovie();

        // show popular movies
        popularMovieListViewModel.getPopularMovie(1);

        // configuring recycleview
        configureRecycleView();
    }


    // init recycleView and adding data to it
    private void configureRecycleView() {
        recycleViewAdapter = new MovieRecycleView( this);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // pagination & loading nect results
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (!recyclerView.canScrollVertically(1)) {
                    // here display next result
                    if (isPopular) {
                        popularMovieListViewModel.popularMovieNextPage();
                    }
                }
            }
        });
    }

    private void ObservasingAnyChangesPopularMovie() {
        popularMovieListViewModel.getPopularMovie().observe(this, movieModels -> {
            // observing any data changes
            if (movieModels != null) {
                for (MovieModel model : movieModels) {
                    // get data
                    recycleViewAdapter.setMovie(movieModels);
                }
            }
        });
    }


    @Override
    public void onMovieClick(int pos) {
        // here is going to detail movie that has clicked
        Intent intent = new Intent(this,DetailMovieActivity.class);
        intent.putExtra("movie",recycleViewAdapter.getSelectedMovie(pos));
        startActivity(intent);
    }
}