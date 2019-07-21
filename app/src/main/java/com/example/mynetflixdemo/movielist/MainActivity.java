package com.example.mynetflixdemo.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mynetflixdemo.moviedetail.MovieDetailsActivity;
import com.example.mynetflixdemo.R;
import com.example.mynetflixdemo.adapter.MovieAdapter;
import com.example.mynetflixdemo.datamodel.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOne;
    private RecyclerView listTwo;
    private RecyclerView listThree;
    private RecyclerView listFour;
    private RecyclerView listFive;
    private RecyclerView listSix;
    private RecyclerView listSeven;
    private RecyclerView listEight;
    private RecyclerView listNine;
    private RecyclerView listTen;

    private ArrayList<Movie> movieList;
    private MovieAdapter adapter;

    private Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
    }

    private void setUp(){
        setUpToolBar();
        initializeListView();
        movieList = initializeMovieList();
        initializeAdapter();
        initializeRecyclerView();
    }

    private void initializeListView(){
        listOne = findViewById(R.id.list_one);
        listTwo = findViewById(R.id.list_two);
        listThree = findViewById(R.id.list_three);
        listFour = findViewById(R.id.list_four);
        listFive = findViewById(R.id.list_five);
        listSix = findViewById(R.id.list_six);
        listSeven = findViewById(R.id.list_seven);
        listEight = findViewById(R.id.list_eight);
        listNine = findViewById(R.id.list_nine);
        listTen = findViewById(R.id.list_ten);
    }

    private ArrayList<Movie> initializeMovieList(){

        ArrayList<Movie> list = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Movie movie = new Movie(Movie.movieNameList[i],
                    Movie.movieImageList[i],
                    getString(R.string.movie_description));
            list.add(movie);
        }

        return list;
    }

    private void initializeAdapter(){
        adapter = new MovieAdapter(this, movieList, new MovieAdapter.MovieClickListener() {

            @Override
            public void onClick(Movie item) {
                Intent intent =
                        new Intent(MainActivity.this, MovieDetailsActivity.class).putExtra("movieDetails", item);
                startActivity(intent);
            }
        });
    }

    private void initializeRecyclerView(){
        listOne.setAdapter(adapter);
        listOne.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listTwo.setAdapter(adapter);
        listTwo.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listThree.setAdapter(adapter);
        listThree.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listFour.setAdapter(adapter);
        listFour.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listFive.setAdapter(adapter);
        listFive.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listSix.setAdapter(adapter);
        listSix.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listSeven.setAdapter(adapter);
        listSeven.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listEight.setAdapter(adapter);
        listEight.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listNine.setAdapter(adapter);
        listNine.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        listTen.setAdapter(adapter);
        listTen.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    public void setUpToolBar(){
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = myToolbar.findViewById(R.id.title);
        mTitle.setText(R.string.app_name);
    }
}
