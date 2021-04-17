package co.edu.iudigital.app.service.impls;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.Movie;
import co.edu.iudigital.app.model.repository.GenderRepository;
import co.edu.iudigital.app.model.repository.MovieRepository;
import co.edu.iudigital.app.service.iface.MovieService;

@Service
public class MovieServiceImplements implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenderRepository genderRepository;
	
	@Override
	public List<Movie> getAll() {
		List<Movie> movies = new ArrayList<>();
		movies = (List<Movie>) movieRepository.findAll();
		return movies;
	}

	@Override
	public void createMovie(Movie movie) {
		boolean existGender = genderRepository.existsById(movie.getGenderId().getId());
		if(existGender) {
			movie.setCreateAt(LocalDateTime.now());
			movieRepository.save(movie);
		}
	}

	@Override
	public void editMovie(Movie movie, int movieId) {
		Optional<Movie> existMovie = movieRepository.findById(movieId);
		if(existMovie.isPresent()) {
			existMovie.get().setName(movie.getName());
			existMovie.get().setDescription(movie.getDescription());
			existMovie.get().setImage(movie.getImage());
			existMovie.get().setActors(movie.getActors());
			existMovie.get().setRating(movie.getRating());
			existMovie.get().setReleaseDate(movie.getReleaseDate());
			boolean existGender = genderRepository.existsById(movie.getGenderId().getId());
			if(existGender) {
				existMovie.get().setGenderId(movie.getGenderId());
			}
			movieRepository.save(existMovie.get());
		}
	}

	@Override
	public void deleteMovie(int movieId) {
		Optional<Movie> existMovie = movieRepository.findById(movieId);
		if(existMovie.isPresent()) {
			movieRepository.delete(existMovie.get());
		}
		/* 
		 boolean existMovie = movieRepository.existsById(movieId);
		if(existMovie) {
			movieRepository.deleteById(movieId);
		}
		 */
	}

	@Override
	public void rateMovie(Movie movie, int movieId) {
		Optional<Movie> existMovie = movieRepository.findById(movieId);
		if(existMovie.isPresent()) {
			existMovie.get().setRating(existMovie.get().getRating() + movie.getRating());
			movieRepository.save(existMovie.get());
		}
		
	}

}
