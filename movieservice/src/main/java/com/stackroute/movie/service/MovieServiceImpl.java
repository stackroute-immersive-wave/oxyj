package com.stackroute.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.CrudsRepository;
import com.stackroute.movie.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{
@Autowired
private MovieRepository movieRepository;
@Autowired
private CrudsRepository crudsRepository;
	@Override
	public List<Movie> listAllMovies() {
		System.out.println("hi service");
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		return movieRepository.findOne(id);
	}

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		System.out.println("i ii am your save service");
		return movieRepository.save(movie);
	}

	@Override
	public void updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		System.out.println(movie.getDescription()+" "+movie.getImdbID()+" "+
			    movie.getPoster()+" "+movie.getTitle()+" "+movie.getYear());
		movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		System.out.println("inside delete controller");
		movieRepository.delete(id);
	}

}
