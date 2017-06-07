package com.stackroute.movie.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.stackroute.movie.domain.Movie;



public interface MovieService {
	public List<Movie> listAllMovies();

	public Movie getMovieById(String id);

	public Movie saveMovie(Movie movie);

	public void updateMovie(String id, Movie movie);
	public void deleteMovie(String id);

}
