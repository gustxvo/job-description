package br.com.gustavoalmeidacarvalho.jobdescription.app.department;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.department.dto.DepartmentDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.DepartmentMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @GetMapping("/arquivamento")
    public String arquivamento(Model model) {
        List<DepartmentDto> departments = departmentMapper.fromEntityList(departmentRepository.findAll());
        System.out.println(departments);
        model.addAttribute("departments", departments);
        return "admin/arquivamento";
    }

    @GetMapping("/organograma")
    public String organizationChart() {
        return "admin/organograma";
    }
}
