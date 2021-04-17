package co.edu.iudigital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Movie;
import co.edu.iudigital.app.service.iface.MovieService;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/all")
	public List<Movie> getAll(){
		return movieService.getAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createMovie(@RequestBody Movie movie) {
		movieService.createMovie(movie);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void editMovie(@RequestBody Movie movie, @PathVariable int id) {
		movieService.editMovie(movie, id);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteMovie( @PathVariable int id) {
		movieService.deleteMovie(id);
	}
	
	@PutMapping("/rate/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void rateMovie(@RequestBody Movie movie, @PathVariable int id) {
		movieService.rateMovie(movie, id);
	}
		
}
