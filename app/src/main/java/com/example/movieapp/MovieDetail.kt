package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.content.Intent
import android.widget.TextView

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var tvMovieTitle: TextView
    private lateinit var tvMovieGenre: TextView
    private lateinit var tvMovieDuration: TextView
    private lateinit var tvMovieAgeLimit: TextView
    private lateinit var tvMovieSynopsis: TextView
    private lateinit var toolbarTitle: TextView // Tambahkan ini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        toolbar = findViewById(R.id.toolbar)
        tvMovieTitle = findViewById(R.id.tv_movie_title)
        tvMovieGenre = findViewById(R.id.tv_movie_genre)
        tvMovieDuration = findViewById(R.id.tv_movie_duration)
        tvMovieAgeLimit = findViewById(R.id.tv_movie_age_limit)
        tvMovieSynopsis = findViewById(R.id.tv_movie_synopsis)
        toolbarTitle = findViewById(R.id.toolbar_title) // Inisialisasi TextView judul

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false) // Menyembunyikan judul default

        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val title = intent.getStringExtra("TITLE")
        val genre = intent.getStringExtra("GENRE")
        val duration = intent.getStringExtra("DURATION")
        val ageLimit = intent.getStringExtra("AGE_LIMIT")
        val synopsis = intent.getStringExtra("SYNOPSIS")

        tvMovieTitle.text = title
        tvMovieGenre.text = genre
        tvMovieDuration.text = duration
        tvMovieAgeLimit.text = ageLimit
        tvMovieSynopsis.text = synopsis
    }
}
