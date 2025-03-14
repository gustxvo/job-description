package br.com.gustavoalmeidacarvalho.jobdescription.app.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.CreateReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.ReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;

@Component
public class ReportMapper {

    public ReportDto fromEntity(Report report) {
        return new ReportDto(report.getId(), report.getReportOwner().getName(), report.getReportOwner().getDepartment(),
                report.getArea(), report.getSignedAt(), report.getCreatedAt());
    }

    public List<ReportDto> fromEntityList(List<Report> reports) {
        return reports.stream()
                .map(this::fromEntity)
                .toList();
    }

    public Report createReportEntity(CreateReportDto reportDto, Integer reportOwnerId) {
        Employee reportOwner = new Employee();
        reportOwner.setUserId(reportOwnerId);
        return Report.builder()
                .reportOwner(reportOwner)
                .affiliation(reportDto.getAffiliation())
                .area(reportDto.getArea())
                .tasks(reportDto.getTasks())
                .kpis(reportDto.getKpis())
                .budgetEuro(reportDto.getBudgetEuro())
                .budgetReal(reportDto.getBudgetReal())
                .createdAt(reportDto.getCreatedAt())
                .signedAt(reportDto.getSignedAt())
                .build();
    }

}
