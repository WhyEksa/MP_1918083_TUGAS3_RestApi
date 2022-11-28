package com.wes.mp_1918083_tugas3_restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wes.mp_1918083_tugas3_restapi.recyclerview.adapters.MovieViewHolder;
import com.wes.mp_1918083_tugas3_restapi.recyclerview.models.MovieModel;
import com.wes.mp_1918083_tugas3_restapi.restapi.utils.Credentials;
import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    private ImageView poster;
    private TextView title,releaseDate,rating,overview;
    LinearLayout dotsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        title = findViewById(R.id.titleDetail);
        releaseDate = findViewById(R.id.releaseDateDetail);
        poster = findViewById(R.id.posterDetail);

        getMovieDetail();
    }

    private void getMovieDetail() {
        if (getIntent().hasExtra("movie")) {
            MovieModel model = getIntent().getParcelableExtra("movie");

            // string text
            TextView[] dots;
            int dotSize = 5;

            title.setText(model.getTitle());
//        ((MovieViewHolder)holder).tagline.setText(movieList.get(position).get());
            releaseDate.setText(model.getRelease_date());

            // poster
            Glide.with(this).load(Credentials.Poster_URL + model.getPoster_path()).into(poster);

        }
    }
}