package com.stackroute.movie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movie.domain.Movie;
@Repository
public interface CrudsRepository extends CrudRepository<Movie, String>{

}
