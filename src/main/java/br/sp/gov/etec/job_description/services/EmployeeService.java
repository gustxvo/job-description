package br.sp.gov.etec.job_description.services;

import br.sp.gov.etec.job_description.model.Employee;
import br.sp.gov.etec.job_description.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    @Autowired
    private final EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

//    public List<Employee> saveEmployeeList(List<Employee> employees){
//        return repository.saveAll(employees);
//    }

    public List<Employee> listEmployees(){
        return (List<Employee>) repository.findAll();
    }

    public Optional<Employee> getEmployee(String employeeId){
        return repository.findById(employeeId);
    }

    public List<Employee> searchEmployees(String keyword){
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
