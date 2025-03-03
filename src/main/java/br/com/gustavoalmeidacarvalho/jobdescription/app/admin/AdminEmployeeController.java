package br.com.gustavoalmeidacarvalho.jobdescription.app.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/colaboradores")
public class AdminEmployeeController {

    @GetMapping
    public String listEmployees(Model model) {
        List<EmployeeDto> employees = List.of(
                new EmployeeDto("00000001", "Alberto", "alberto@acme.com", "TI", "Team Lead", BigDecimal.valueOf(3500), "Ativo")
        );
        model.addAttribute("employees", employees);
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
