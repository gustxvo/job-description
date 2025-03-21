package br.com.gustavoalmeidacarvalho.jobdescription.app.employee;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.ReportMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.CreateReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.Department;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ReportEmployeeController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @GetMapping("/criar-relatorio")
    public String createReportForm(Model model, Authentication authentication) {
        Integer reportOwnerId = Integer.parseInt(authentication.getName());
        Department department = reportService.findDepartmentByEmployeeId(reportOwnerId);
        model.addAttribute("report", new CreateReportDto(reportOwnerId, department.getNamePtBr()));
        return "employees/form-report";
    }

    @PostMapping("/criar-relatorio")
    public String saveReport(@ModelAttribute CreateReportDto reportDto) {
        Report reportEntity = reportMapper.createReportEntity(reportDto);

        reportService.save(reportEntity);
        return "redirect:/login"; // Redirect to employee portal in the future
    }

}
