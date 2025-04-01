package br.com.gustavoalmeidacarvalho.jobdescription.app.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.CompanyAffiliation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
        private Long id;
        private String reportOwner;
        private String department;
        private CompanyAffiliation affiliation;
        private String area;
        private List<TaskDto> tasks = new ArrayList<>();
        private Set<KpiDto> kpis = new HashSet<>();
        private BigDecimal budgetEuro;
        private BigDecimal budgetReal;
        private LocalDate createdAt;
        private LocalDate signedAt;
}
