package co.edu.iudigital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Gender;
import co.edu.iudigital.app.service.iface.GenderService;


@RestController
@RequestMapping("/gender")
//@CrossOrigin("*") // Sirve para controlar quien hace las peticiones, * siginifica que todos
public class GenderController {

	@Autowired
	private GenderService genderService;
	
	//@GetMapping("/all")
	@GetMapping
	public List<Gender> getAll(){
		return genderService.getAll();
	}
}
