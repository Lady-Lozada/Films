package co.edu.iudigital.app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.app.model.entity.Gender;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Integer>{
	

}
