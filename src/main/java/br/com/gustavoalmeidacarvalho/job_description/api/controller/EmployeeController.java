package br.com.gustavoalmeidacarvalho.job_description.api.controller;

import br.com.gustavoalmeidacarvalho.job_description.domain.user.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("home")
    public String listEmployees(Model model, @Param("keyword") String keyword){
        if (keyword != null){
            model.addAttribute("employees", service.searchEmployees(keyword));
        } else {
            model.addAttribute("employees", service.listEmployees());
        }
        return "home";
    }

//
//    @GetMapping("employees")
//    public Employee addEmployee(@RequestBody Employee employee){
//        return service.saveEmployee(employee);
//    }
//
//    @GetMapping("employees/save-list")
//    public List<Employee> addEmployeeList(@RequestBody List<Employee> employees){
//        return service.saveEmployeeList(employees);
//    }
//
////    @GetMapping("employees/edit/{employeeId}")
////    public  String editEmployee(@PathVariable String employeeId){
////        return service.saveEmployee(employeeId);
////    }
////
////    @PostMapping("employees/edit/{employeeId}")
//
//
////    @GetMapping("employees/{employeeId}")
////    public  Employee editEmployee(@PathVariable String employeeId){
////        return service.getEmployee(employeeId);
////    }
//
////    @GetMapping("employees/{employeeId}")
////    public  Employee deleteEmployee(@PathVariable String employeeId){
////        return service.deleteEmployee(employeeId);
////    }

//    @GetMapping("search")
//    public String searchEmployees(@Param("keyword") String keyword, Model model){
//        List<Employee> search = service.searchEmployees(keyword);
//        model.addAttribute("search", search);
//        return "home";
//        Optional<Employee> employees = service.getEmployee(employee.getEmployeeId());
//        model.addAttribute("employees", employees);
//        return "home";
//    }

//    public List<Employee> findByKeyword(String keyword){
//        return employeeRepository.searchEmployees(keyword);
//    }
//    public List<Employee> searchEmployees(@Param("keyword") String keyword){
//        return service.searchEmployees(keyword);
//    }
}
