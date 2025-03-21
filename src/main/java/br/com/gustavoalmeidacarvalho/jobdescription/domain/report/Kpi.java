package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
