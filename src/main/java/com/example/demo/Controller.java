package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired // This means to get the bean called EmployeeRepository
  	private EmployeeRepository empRepository;

	@GetMapping("/")
	public String index() {
		return "Hi Capgemini!,Greetings from Spring Boot";
	}
	// Validado: recoge todo los empleados
	@GetMapping(path="/get")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return empRepository.findAll();
	}
	// Validado: inserta el empleado
	@PostMapping(path="/post") // Map ONLY POST Requests
	public @ResponseBody String addNewEmp(@RequestParam String name, @RequestParam String role) {
		empRepository.save(new Employee(name,role));
		return "Saved";
	}
	//Validado: actualiza un empleado
	@PutMapping(path = "/put")
	public @ResponseBody String putEmp(@RequestParam Long id,@RequestParam String name, @RequestParam String role){
		Employee user=empRepository.getReferenceById(id);
		user.setName(name);
		user.setRole(role);
		empRepository.save(user);
		return "Saved";
	}
	// Validado:borra todos los empleados
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteEmp(){
			empRepository.deleteAll();
			return "all rows deleted";
	}
}
