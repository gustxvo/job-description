package br.com.gustavoalmeidacarvalho.jobdescription.app.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.AddressDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.EmployeeDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.EmployeeStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/colaboradores")
public class AdminEmployeeController {

    List<EmployeeDto> employees = new ArrayList<>();

    public AdminEmployeeController() {
        var fakeAddress = new AddressDto("Street", "number", "complement", "city", "state", "zip");
        employees
                .add(new EmployeeDto("000001", "Alfredo", "1231231", "143", "123", fakeAddress, "Senior", "TI", "email",
                        "phoneExt", BigDecimal.valueOf(5000),
                        EmployeeStatus.ACTIVE,
                        LocalDate.now(),
                        null));
        employees.add(new EmployeeDto("000002", "João", "1231231", "143", "123", fakeAddress, "Senior", "TI", "email",
                "phoneExt", BigDecimal.valueOf(5000),
                EmployeeStatus.TERMINATED,
                LocalDate.now().minusMonths(6),
                LocalDate.now()));

    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "admin/home";
    }

    @GetMapping("/{employeeId}")
    public String getEmployeeById(@PathVariable String employeeId, Model model) {
        var employee = employees.stream().filter(e -> employeeId.equals(e.getId())).findFirst().orElseThrow();
        model.addAttribute("employee", employee);
        return "admin/employee-form";
    }

    @GetMapping("/registrar")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "admin/employee-form";
    }

    @PostMapping("/registrar")
    public String createEmployee(@ModelAttribute EmployeeDto employee, Model model) {
        model.addAttribute("employee", employee);
        employees.add(employee);
        return "redirect:/admin/colaboradores";
    }

}
