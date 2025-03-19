package br.com.gustavoalmeidacarvalho.jobdescription.app.admin;

import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.EmployeeDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.EmployeeMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/colaboradores")
public class AdminEmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public String listEmployees(Model model) {
        List<EmployeeDto> employees = employeeMapper.fromEntityList(employeeService.findAll());
        model.addAttribute("employees", employees);
        return "admin/home";
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeById(@PathVariable String employeeId, Model model) {
        int userId = employeeMapper.getUserId(employeeId);
        EmployeeDto employee = employeeMapper.fromEntity(employeeService.findById(userId));
        model.addAttribute("employee", employee);
        return "admin/employee-form";
    }

    @GetMapping("/registrar")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "admin/employee-form";
    }

    @PostMapping("/registrar")
    public String createEmployee(@ModelAttribute EmployeeDto employee) {
        Employee employeeEntity = employeeMapper.createEmployeeEntity(employee);
        employeeService.save(employeeEntity);
        return "redirect:/admin/colaboradores";
    }

}
