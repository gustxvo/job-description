package br.com.gustavoalmeidacarvalho.job_description.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public UserRepository.Employee saveEmployee(UserRepository.Employee employee){
        return repository.save(employee);
    }

//    public List<Employee> saveEmployeeList(List<Employee> employees){
//        return repository.saveAll(employees);
//    }

    public List<UserRepository.Employee> listEmployees(){
        return (List<UserRepository.Employee>) repository.findAll();
    }

    public Optional<UserRepository.Employee> getEmployee(String employeeId){
        return repository.findById(employeeId);
    }

    public List<UserRepository.Employee> searchEmployees(String keyword){
        return repository.searchEmployees(keyword);
    }


//    public Employee editEmployee(String employeeId){
//        Optional<Employee> employee = repository.findById(employeeId);
//        return repository.save(employeeId);
//    }
//
//    public Optional<Employee> deleteEmployee(String id){
//        return repository.deleteById(id);
//    }

}
