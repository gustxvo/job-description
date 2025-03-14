package br.com.gustavoalmeidacarvalho.jobdescription.app.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.ReportMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.CreateReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.CompanyAffiliation;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportService;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportTask;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ReportEmployeeController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @GetMapping("/criar-relatorio")
    public String createReportForm(Model model) {
        model.addAttribute("report", new CreateReportDto());
        return "employees/form-report";
    }

    @PostMapping("/criar-relatorio")
    public String saveReport(Model model, Authentication authentication) {
        model.addAttribute("report", new CreateReportDto());
        Integer reportOwnerId = Integer.parseInt(authentication.getName());

        CreateReportDto reportDto = new CreateReportDto(CompanyAffiliation.ACME_AF, "Area", null, null,
                BigDecimal.ONE, BigDecimal.TEN, LocalDate.now(), null);

        Report reportEntity = reportMapper.createReportEntity(reportDto, reportOwnerId);
        ReportTask task1 = new ReportTask("Task #1", reportEntity);
        ReportTask task2 = new ReportTask("Task #2", reportEntity);
        reportEntity.setTasks(List.of(task1, task2));

        reportService.save(reportEntity);
        return "redirect:/login"; // Redirect to employee portal in the future
    }

}
