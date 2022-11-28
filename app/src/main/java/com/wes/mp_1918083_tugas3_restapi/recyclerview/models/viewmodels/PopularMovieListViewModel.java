package com.wes.mp_1918083_tugas3_restapi.recyclerview.models.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wes.mp_1918083_tugas3_restapi.recyclerview.models.MovieModel;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.repositories.PopularMovieRepository;

import java.util.List;

public class PopularMovieListViewModel extends ViewModel {
    private PopularMovieRepository popularMovieRepository;

    public PopularMovieListViewModel() {
        popularMovieRepository = PopularMovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getPopularMovie() {
        return popularMovieRepository.getPopularMovie();
    }

    public void getPopularMovie(int page) {
        popularMovieRepository.getPopularMovie(page);
    }

    // next page
    public void popularMovieNextPage() {
        popularMovieRepository.popularMovieNextPage();
    }
}

