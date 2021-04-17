package co.edu.iudigital.app.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.app.model.entity.User;


public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByEmailAndPassword(String email, String password);

	public Optional<User> findByName(String name);
	
	//public User findByName(String name);
}
