package br.com.gustavoalmeidacarvalho.jobdescription.app.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto.ReportDto;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;

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

}
