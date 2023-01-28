package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-Movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added succesfully", HttpStatus.CREATED);

    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added succesfully", HttpStatus.CREATED);

    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie, @RequestParam String director)
    {
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New Movie Director Pair added succesfully", HttpStatus.CREATED);

    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String movie)
    {
        Movie movieresult=movieService.getMovieByName(movie);
        return new ResponseEntity<>(movieresult, HttpStatus.CREATED);

    }
    @GetMapping("s/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String director)
    {
        Director directorresult=movieService.getDirectorByName(director);
        return new ResponseEntity<>(directorresult, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director)
    {
        List<String> result=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> result=movieService.findAllMovies();
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);

    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);

    }

}
