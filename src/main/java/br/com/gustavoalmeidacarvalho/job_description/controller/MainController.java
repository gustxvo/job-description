package br.com.gustavoalmeidacarvalho.job_description.controller;

import br.com.gustavoalmeidacarvalho.job_description.model.Employee;
import br.com.gustavoalmeidacarvalho.job_description.model.User;
import br.com.gustavoalmeidacarvalho.job_description.repository.EmployeeRepository;
import br.com.gustavoalmeidacarvalho.job_description.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository eRepository;

	@GetMapping("/users")
	public List<User> users() {
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/employees")
	public List<Employee> e() {
		return (List<Employee>) eRepository.findAll();
	}

	@GetMapping("/id")
	public String foo(HttpSession session) {
		return session.getId();
	}
}
