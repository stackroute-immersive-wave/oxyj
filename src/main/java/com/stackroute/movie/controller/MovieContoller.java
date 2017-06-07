package com.stackroute.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.hateoes.LinkHateoes;
import com.stackroute.movie.service.MovieService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@RestController
@RefreshScope
@RequestMapping(value="/movie")
public class MovieContoller {
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private MovieService movieService;
@Autowired
private LinkHateoes linkHateoes;
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="",method=RequestMethod.GET)
public @ResponseBody  Iterable<Movie>  list() {
System.out.println("hi contolerer");
List<Movie> allmovies = (List<Movie>) movieService.listAllMovies();
List<Movie> all=linkHateoes.getallmovielinks(allmovies);
return all;
}

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="{id}",method=RequestMethod.GET)
public Movie getMovie(@PathVariable String id){
	return movieService.getMovieById(id);
}

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="",method=RequestMethod.POST)
public Movie saveMovie(@RequestBody Movie movie){
	System.out.println("i ii am your save vontoller"+movie.getImdbID());
	//logger.debug("hi this is controller"+movie.getImdbID()+" "+movie.getPoster());
	//String m[]=movie.getYear().split("-");
	
	return movieService.saveMovie(movie);
}

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="{id}",method=RequestMethod.PUT)
public ResponseEntity updateMovie(@PathVariable String id, @RequestBody Movie movie){
    Movie m=movieService.getMovieById(id);
	m.setImdbID(movie.getImdbID());
    m.setTitle(movie.getTitle());
    m.setPoster(movie.getPoster());
    m.setYear(movie.getYear());
    m.setDescription(movie.getDescription());
    System.out.println(m.getDescription()+" "+m.getImdbID()+" "+
    m.getPoster()+" "+m.getTitle()+" "+m.getYear());
    movieService.updateMovie(id,movie);
    //return m1;
    Map<String, String> msgMap = new HashMap<String,String>();
    msgMap.put("message","Movie updated successsfully");
    return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
}

//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="{id}",method=RequestMethod.DELETE)
public ResponseEntity deleteMovie(@PathVariable String id){
	System.out.println("inside delete controller");
	movieService.deleteMovie(id);
	Map msgMap = new HashMap<String,String>();
    msgMap.put("message","Movie deleted successsfully");
    return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
}

}
