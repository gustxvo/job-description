package br.com.gustavoalmeidacarvalho.jobdescription.app.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/colaboradores")
public class AdminEmployeeController {

    @GetMapping
    public String listEmployees() {
        return "admin/home";
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeById(@PathVariable String employeeId) {
        return "admin/employee-info";
    }

    @GetMapping("/registro")
    public String createEmployeeForm() {
        return "admin/register-employee";
    }

    @PostMapping("/registrar")
    public String createEmployee() {
        return "redirect:/admin/home";
    }

}
