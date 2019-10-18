package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Movie;

public interface IMovieRepository extends MongoRepository<Movie, String>{
	public Movie save(Movie movie);

}
