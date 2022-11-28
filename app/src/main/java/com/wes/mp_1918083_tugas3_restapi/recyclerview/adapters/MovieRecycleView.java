package com.wes.mp_1918083_tugas3_restapi.recyclerview.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wes.mp_1918083_tugas3_restapi.R;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.models.MovieModel;
import com.wes.mp_1918083_tugas3_restapi.restapi.utils.Credentials;

import java.util.List;

public class MovieRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> movieList;
    private final OnMovieListener onMovieListener;

    public MovieRecycleView(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        return new MovieViewHolder(view,onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // string text
        TextView[] dots;
        int dotSize = 5;

        ((MovieViewHolder)holder).title.setText(movieList.get(position).getTitle());
        ((MovieViewHolder)holder).releaseDate.setText(movieList.get(position).getRelease_date());

        // poster
        Glide.with(holder.itemView.getContext()).load(Credentials.Poster_URL + movieList.get(position).getPoster_path()).into(((MovieViewHolder) holder).poster);

    }

    @Override
    public int getItemCount() {
        if (movieList != null) {
            return movieList.size();
        } return 0;
    }

    public void setMovie(List<MovieModel> list) {
        this.movieList = list;
        notifyDataSetChanged();
    }

    public MovieModel getSelectedMovie(int pos) {
        if (movieList != null) {
            if (movieList.size() > 0) {
                return movieList.get(pos);
            }
        } return null;
    }
}

