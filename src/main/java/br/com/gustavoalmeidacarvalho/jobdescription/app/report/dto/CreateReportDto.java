package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.CompanyAffiliation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateReportDto {

    private final Integer reportOwnerId;
    private final String department;
    private CompanyAffiliation affiliation;
    private String area;
    private List<TaskDto> tasks = new ArrayList<>();
    private List<KpiDto> kpis = new ArrayList<>();
    private BigDecimal budgetEuro;
    private BigDecimal budgetReal;
    private LocalDate createdAt;
    private LocalDate signedAt;

    public CreateReportDto(Integer reportOwnerId, String department) {
        this.reportOwnerId = reportOwnerId;
        this.department = department;
    }
}
