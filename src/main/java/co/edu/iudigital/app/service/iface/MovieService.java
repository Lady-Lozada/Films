package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.model.entity.Movie;

public interface MovieService {

	/**
	 * Listar todas las peliculas
	 * @return
	 */
	public List<Movie> getAll();
	
	/**
	 * Crear una pélicula
	 * @param movie
	 */
	public void createMovie(Movie movie);
	
	/**
	 * Editar una pelicula por su id
	 * @param movie
	 * @param movieId
	 */
	public void editMovie(Movie movie, int movieId);
	
	/**
	 * Boora una pelicula por su Id
	 * @param movieId
	 */
	public void deleteMovie(int movieId);
	
	/**
	 * Califica una pelicula
	 * @param movie
	 * @param movieId
	 */
	public void rateMovie(Movie movie, int movieId);
}
