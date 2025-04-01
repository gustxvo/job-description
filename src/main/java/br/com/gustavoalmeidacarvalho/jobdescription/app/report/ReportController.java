package br.com.gustavoalmeidacarvalho.jobdescription.app.report;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.ReportMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.ReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @GetMapping("/controle-form")
    public String ongoingReports(Model model) {
        List<ReportDto> reports = reportMapper.fromEntityList(reportService.findAll());
        System.out.println("Reports!!!!!");
        System.out.println(reports);
        model.addAttribute("reports", reports);
        return "admin/controle-form";
    }

    @GetMapping("/reports/visualizar/{reportId}")
    public String viewReport(@PathVariable Long reportId, Model model) {
        ReportDto report = reportMapper.fromEntity(reportService.findById(reportId));
        System.out.println(report);
        model.addAttribute("report", report);
        return "admin/view-report";
    }

}
