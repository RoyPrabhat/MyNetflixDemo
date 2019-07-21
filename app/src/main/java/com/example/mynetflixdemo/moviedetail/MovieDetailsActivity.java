package com.example.mynetflixdemo.moviedetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mynetflixdemo.movieplayer.PlayerActivity;
import com.example.mynetflixdemo.R;
import com.example.mynetflixdemo.datamodel.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView movieImage;
    private TextView movieDescription;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_movie_detail);
        setUp();
    }

    public void setUp() {
        Movie movieDetails = getIntent().getExtras().getParcelable(getString(R.string.movie_details));
        movieImage = findViewById(R.id.image);
        movieImage.setImageDrawable(getDrawable(movieDetails.getImage()));
        movieDescription = findViewById(R.id.description);
        movieDescription.setText(movieDetails.getDescription());
        setUpToolBar(movieDetails.getName());
    }

    public void setUpToolBar(String name) {
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(name);
    }


    public void playMovie(View view) {
        Intent intent =
                new Intent(MovieDetailsActivity.this, PlayerActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
