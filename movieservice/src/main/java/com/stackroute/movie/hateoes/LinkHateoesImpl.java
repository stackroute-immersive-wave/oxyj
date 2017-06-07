package com.stackroute.movie.hateoes;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.stackroute.movie.controller.MovieContoller;
import com.stackroute.movie.domain.Movie;
@Service
public class LinkHateoesImpl implements LinkHateoes{

	@Override
	public List<Movie> getallmovielinks(List<Movie> allmovies) {
		// TODO Auto-generated method stub
		 for ( Movie movie : allmovies) {
		        Link selfLink = linkTo(MovieContoller.class).slash(movie.getImdbID()).withSelfRel();
		       // Link  insertlink= linkTo(MovieController.class).slash(movie.getImdbID()).withRel("Insert");
		        Link  updatelink= linkTo(MovieContoller.class).slash(movie.getImdbID()).withRel("Update");
		        Link  removelink= linkTo(MovieContoller.class).slash(movie.getImdbID()).withRel("Delete");
		        
		        movie.add(selfLink);
		        //movie.add(insertlink);
		        movie.add(updatelink);
		        movie.add(removelink);
		        
		    }
		 return allmovies;
		}
		
	

}
