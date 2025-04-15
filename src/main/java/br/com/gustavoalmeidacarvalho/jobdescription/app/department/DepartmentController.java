package br.com.gustavoalmeidacarvalho.jobdescription.app.department;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.DepartmentDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.EmployeeOrgDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.DepartmentMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.DepartmentRepository;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.OrganizationChartService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final OrganizationChartService organizationChartService;

    @GetMapping("/arquivamento")
    public String arquivamento(Model model) {
        List<DepartmentDto> departments = departmentMapper.fromEntityList(departmentRepository.findAll());
        System.out.println(departments);
        model.addAttribute("departments", departments);
        return "admin/arquivamento";
    }

    @GetMapping("/organograma")
    public String organizationChart(Model model) {
        List<EmployeeOrgDto> employees = organizationChartService.findEmployees();
        model.addAttribute("employees", employees);
        return "admin/organograma";
    }
}
