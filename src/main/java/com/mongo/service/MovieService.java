package com.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongo.model.Movie;
import com.mongo.request.MovieRequest;

@Service
public class MovieService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Movie saveMovie(Movie movie) {
		
		mongoTemplate.save(movie);
		return movie;
	}

	public List<MovieRequest> getMoviesList() {
		
		Query query = new Query();

		List<Movie> myClassList=  mongoTemplate.find(query, Movie.class);
		
		List<MovieRequest> movieRequestList = new ArrayList<MovieRequest>();
		
		if(myClassList == null ) {
			return movieRequestList;
		}
		
		for (Movie movie : myClassList) {
			MovieRequest movieRequest = new MovieRequest();
			movieRequest.setImdbID(movie.getId());
			movieRequest.setTitle(movie.getTitle());
			movieRequest.setYear(movie.getYear());
			
			movieRequestList.add(movieRequest);
		}
		
		return movieRequestList;
	}

}
