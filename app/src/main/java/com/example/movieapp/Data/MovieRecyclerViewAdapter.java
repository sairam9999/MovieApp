package com.example.movieapp.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieapp.Model.Movie;
import com.example.movieapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import it.sephiroth.android.library.picasso.Picasso;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies){
        this.context = context;
        movieList = movies;
    }

    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.movie_row), parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        String posterLink = movie.getPoster();
        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getMovieType());

        Picasso.with(context).load(posterLink).placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);

        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView poster;
        TextView year;
        TextView type;


        public ViewHolder(View itemView, Context ctx){
            super(itemView);
            context = ctx;

            title = (TextView) itemView.findViewById(R.id.movieTitleId);
            poster = (ImageView) itemView.findViewById(R.id.movieImageId);
            year = (TextView) itemView.findViewById(R.id.movieReleaseId);
            type = (TextView) itemView.findViewById(R.id.movieCategoryId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, "on Clicked Here", Toast.LENGTH_LONG).show();

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
