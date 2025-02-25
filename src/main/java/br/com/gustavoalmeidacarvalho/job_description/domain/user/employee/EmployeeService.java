package br.com.gustavoalmeidacarvalho.job_description.domain.user.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.EmployeeRepository repository;

    public br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee saveEmployee(br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee employee){
        return repository.save(employee);
    }

//    public List<Employee> saveEmployeeList(List<Employee> employees){
//        return repository.saveAll(employees);
//    }

    public List<br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee> listEmployees(){
        return (List<br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee>) repository.findAll();
    }

    public Optional<br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee> getEmployee(String employeeId){
        return repository.findById(employeeId);
    }

    public List<br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee> searchEmployees(String keyword){
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
