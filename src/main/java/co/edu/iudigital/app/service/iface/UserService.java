package co.edu.iudigital.app.service.iface;

import co.edu.iudigital.app.model.entity.User;

public interface UserService {

	/**
	 * Metodo para crear un nuevo usuario
	 * @param user
	 */
	public User createUser(User user);
	
	/**
	 * Loguin de usuario
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
}
