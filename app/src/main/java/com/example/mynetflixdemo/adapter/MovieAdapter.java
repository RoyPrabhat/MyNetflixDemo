package com.example.mynetflixdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mynetflixdemo.R;
import com.example.mynetflixdemo.datamodel.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    public interface MovieClickListener {
        void onClick(Movie item);
    }

    private LayoutInflater inflater;
    private ArrayList<Movie> movieList;
    private final MovieClickListener listener;

    public MovieAdapter(Context context, ArrayList<Movie> movieList, MovieClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.movieList = movieList;
        this.listener = listener;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_movie_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        holder.movieImage.setImageResource(movieList.get(position).getImage());
        holder.movieName.setText(movieList.get(position).getName());
        holder.bind(movieList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movieName;
        ImageView movieImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieImage = itemView.findViewById(R.id.movieImage);
        }


        public void bind(final Movie item, final MovieClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(item);
                }
            });
        }
    }
}