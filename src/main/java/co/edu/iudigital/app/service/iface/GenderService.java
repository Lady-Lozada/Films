package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.model.entity.Gender;

public interface GenderService {

	/**
	 * Retorna la lista de generos de la base de datos
	 * @return
	 */
	List<Gender> getAll();
}
