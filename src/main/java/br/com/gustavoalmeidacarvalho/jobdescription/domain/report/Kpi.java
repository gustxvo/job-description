package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_kpis")
public class Kpi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kpi_id")
    private Integer id;

    private String description;

    @Column(name = "kpi_value")
    private BigDecimal value;

    @ManyToMany(mappedBy = "kpis")
    private Set<Report> reports = new HashSet<>();

    public Kpi(String description, BigDecimal value, Report report) {
        this.description = description;
        this.value = value;
        reports.add(report);
    }

    public void addReport(Report report) {
        reports.add(report);
    }

}
