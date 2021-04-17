package co.edu.iudigital.app.service.impls;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.User;
import co.edu.iudigital.app.model.repository.UserRepository;
import co.edu.iudigital.app.service.iface.UserService;

@Service
public class UserServiceImplements implements UserService{

	@Autowired
	private UserRepository userRepository;
		
	@Transactional
	public User createUser(User user) {
		
		try {
			Optional<User> existUser = userRepository.findByName(user.getName());
			
			System.out.println("existUser " + existUser);
			
			if(!existUser.isPresent()) {
				user.setCreateAt(LocalDateTime.now());
				return userRepository.save(user);
			}
		} catch (Exception e) {
			System.out.println("Error al guardar usuario: " + e.getMessage());
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User login(User user) throws Exception {
		User existUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(existUser == null) {
			throw new Exception("Usuario y/o contraseña incorrecto!");
		}
		return existUser;
	}

}
