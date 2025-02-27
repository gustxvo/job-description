package br.com.gustavoalmeidacarvalho.jobdescription.domain.department;

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
