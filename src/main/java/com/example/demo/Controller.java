package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping(path="/get")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return empRepository.findAll();
	}
	@PostMapping(path="/post") // Map ONLY POST Requests
	public @ResponseBody String addNewEmp(@RequestParam String name, @RequestParam String role) {
		empRepository.save(new Employee(name,role));
		return "Saved";
	}
	@PutMapping(path = "/put")
	public @ResponseBody String putEmp(@RequestParam Integer id,@RequestParam String name, @RequestParam String role){
		Employee user=empRepository.getReferenceById(id);
		user.setName(name);
		user.setRole(role);
		empRepository.save(user);
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteEmp(){
			empRepository.deleteAll();
			return "all rows deleted";
	}
}
