package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.CompanyAffiliation;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Kpi;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportDto {

    private CompanyAffiliation affiliation;
    private String area;
    private List<ReportTask> tasks;
    private Set<Kpi> kpis;
    private BigDecimal budgetEuro;
    private BigDecimal budgetReal;
    private LocalDate createdAt;
    private LocalDate signedAt;

}
