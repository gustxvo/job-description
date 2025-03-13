package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "report_owner_id", nullable = false)
    private Employee reportOwner;

    @Enumerated(value = EnumType.ORDINAL)
    private CompanyAffiliation affiliation;

    @Column(name = "area", length = 200)
    private String area;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<ReportTask> tasks;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "report_kpis", joinColumns = @JoinColumn(name = "report_id"), inverseJoinColumns = @JoinColumn(name = "kpi_id"))
    private Set<Kpi> kpis;

    @Column(name = "budget_euro", length = 20)
    private BigDecimal budgetEuro;

    @Column(name = "budget_real", length = 20)
    private BigDecimal budgetReal;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "signed_at")
    private LocalDate signedAt;

}
