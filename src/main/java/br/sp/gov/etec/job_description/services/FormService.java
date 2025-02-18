package br.sp.gov.etec.job_description.services;

import br.sp.gov.etec.job_description.model.Akv;
import br.sp.gov.etec.job_description.model.Department;
import br.sp.gov.etec.job_description.model.Employee;
import br.sp.gov.etec.job_description.repository.DepartmentRepository;
import br.sp.gov.etec.job_description.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormService {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> listDepartment(){
        return repository.findAll();
    }

    public List<Department> searchDepartment(String keyword){
        return repository.searchDepartment(keyword);
    }
}
