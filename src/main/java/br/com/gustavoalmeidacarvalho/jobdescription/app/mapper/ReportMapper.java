package br.com.gustavoalmeidacarvalho.jobdescription.app.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.CreateReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.KpiDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.ReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.TaskDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Kpi;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportTask;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;

@Component
public class ReportMapper {

    public ReportDto fromEntity(Report report) {
        List<TaskDto> tasks = report.getTasks().stream()
                .map(task -> new TaskDto(task.getDescription()))
                .toList();

        Set<KpiDto> kpis = report.getKpis().stream()
                .map(kpi -> new KpiDto(kpi.getDescription(), kpi.getValue()))
                .collect(Collectors.toSet());

        System.out.println(report);
        return new ReportDto(report.getId(), report.getReportOwner().getName(), report.getReportOwner().getDepartment(),
                report.getAffiliation(),
                report.getArea(), tasks, kpis, report.getBudgetEuro(), report.getBudgetReal(), report.getSignedAt(),
                report.getCreatedAt());
    }

    public List<ReportDto> fromEntityList(List<Report> reports) {
        return reports.stream()
                .map(this::fromEntity)
                .toList();
    }

    public Report createReportEntity(CreateReportDto reportDto) {
        Employee reportOwner = new Employee(reportDto.getReportOwnerId());

        Report report = Report.builder()
                .reportOwner(reportOwner)
                .affiliation(reportDto.getAffiliation())
                .area(reportDto.getArea())
                .budgetEuro(reportDto.getBudgetEuro())
                .budgetReal(reportDto.getBudgetReal())
                .createdAt(reportDto.getCreatedAt())
                .signedAt(reportDto.getSignedAt())
                .build();

        List<ReportTask> tasks = tasksFromList(reportDto.getTasks(), report);
        Set<Kpi> kpis = kpisFromDto(reportDto.getKpis(), report);
        report.setTasks(tasks);
        report.setKpis(kpis);

        return report;
    }

    private List<ReportTask> tasksFromList(List<TaskDto> tasks, Report report) {
        return tasks.stream()
                .filter(task -> task.getDescription() != null)
                .map(task -> new ReportTask(task.getDescription(), report))
                .toList();
    }

    private Set<Kpi> kpisFromDto(List<KpiDto> kpis, Report report) {
        return kpis.stream()
                .filter(kpi -> kpi.getDescription() != null || kpi.getValue() != null)
                .map(kpi -> new Kpi(kpi.getDescription(), kpi.getValue(), report))
                .collect(Collectors.toSet());
    }

}
