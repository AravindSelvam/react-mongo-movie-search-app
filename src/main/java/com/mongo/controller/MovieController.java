package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Movie;
import com.mongo.request.MovieRequest;
import com.mongo.service.MovieService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/save/movie")
	public String saveMovie(@RequestBody MovieRequest movieRequest) throws Exception {
		
		validate(movieRequest);
		
		Movie movie = new Movie();
		movie.setId(movieRequest.getImdbID());
		movie.setTitle(movieRequest.getTitle());
		movie.setYear(movieRequest.getYear());
		
		movieService.saveMovie(movie);
		System.out.println("movie saved");
		return "success";
	}
	
	@RequestMapping(value="/get/movies",method = RequestMethod.GET)
	public List<MovieRequest> getMovieList(){
		List<MovieRequest> movieRequestList = movieService.getMoviesList();
		return movieRequestList;
	}

	private void validate(MovieRequest movieRequest) throws Exception {
		
		if(movieRequest == null) {
			throw new Exception("Invalid movie Request");
		}
		
		if(movieRequest.getImdbID() == null || movieRequest.getImdbID().isEmpty()) {
			throw new Exception("Invalid ImdbID");
		}
		
	}

}
