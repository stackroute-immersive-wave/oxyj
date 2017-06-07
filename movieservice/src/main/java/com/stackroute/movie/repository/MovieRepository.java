package com.stackroute.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movie.domain.Movie;
@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{

}
