package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        if (employee.getPassword() == null) {
            employee.setPassword(passwordEncoder.encode(employee.getUserId()));
        }
        return employeeRepository.save(employee);
    }

//    public List<Employee> saveEmployeeList(List<Employee> employees){
//        return repository.saveAll(employees);
//    }

    public List<Employee> listEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

    public Employee findById(int userId) {
        return employeeRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with id " + userId));
    }

}
