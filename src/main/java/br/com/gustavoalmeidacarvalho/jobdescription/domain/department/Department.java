package br.com.gustavoalmeidacarvalho.jobdescription.domain.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false, length = 8)
    private Integer id;

    @Column(name = "name_en", nullable = false, length = 50)
    private String nameEn;

    @Column(name = "name_pt_br", nullable = false, length = 50)
    private String namePtBr;

    @Column(nullable = false, length = 5)
    private String acronym;

    @OneToOne
    @JoinColumn(name = "position_holder_id", nullable = false)
    private Employee holder;

}
