package br.sp.gov.etec.job_description.controller;

import br.sp.gov.etec.job_description.model.Employee;
import br.sp.gov.etec.job_description.model.User;
import br.sp.gov.etec.job_description.repository.EmployeeRepository;
import br.sp.gov.etec.job_description.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final EmployeeRepository eRepository;

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
