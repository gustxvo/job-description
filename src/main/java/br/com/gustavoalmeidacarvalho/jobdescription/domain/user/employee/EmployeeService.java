package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Employee findById(int userId) {
        return employeeRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with id " + userId));
    }

}
