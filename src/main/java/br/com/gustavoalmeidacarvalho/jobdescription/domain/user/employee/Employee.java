package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_employees")
public class Employee extends User {

    @Column(nullable = false, length = 75)
    private String name;

    @Column(nullable = false, length = 50)
    private String office;

    @Column(name = "ou_dep", length = 8)
    private String ouDep;

    @Column(name = "phone_ext", length = 8)
    private String phoneExt;

    @Column(length = 8)
    private String cpi;

    @Column(length = 8)
    private String cost;

    public Employee() {
        super("EMPLOYEE");
    }

    public Employee(
            String password,
            boolean locked,
            boolean enabled,
            String name,
            String office,
            String ouDep,
            String phoneExt
    ) {
        super(password, "EMPLOYEE", locked, enabled);
        this.name = name;
        this.office = office;
        this.ouDep = ouDep;
        this.phoneExt = phoneExt;
    }

    public Employee(
            Integer userId,
            String password,
            boolean locked,
            boolean enabled,
            String name,
            String office,
            String ouDep,
            String phoneExt,
            String cpi,
            String cost
    ) {
        super(userId, password, "EMPLOYEE", locked, enabled);
        this.name = name;
        this.office = office;
        this.ouDep = ouDep;
        this.phoneExt = phoneExt;
        this.cpi = cpi;
        this.cost = cost;
    }
}
