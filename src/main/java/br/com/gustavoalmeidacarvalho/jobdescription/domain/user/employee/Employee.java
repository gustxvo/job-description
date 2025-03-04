package br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tb_employees")
public class Employee extends User {

    @Column(nullable = false, length = 75)
    private String name;

    @Column(nullable = false, length = 50)
    private String rg;

    @Column(nullable = false, length = 11)
    private String cpf;

    private String phone;

    @Embedded
    private Address address;

    private String position;
    private String department;
    private String email;

    @Column(name = "phone_ext", length = 8)
    private String phoneExt;

    private BigDecimal salary;
    private EmployeeStatus status;
    private LocalDate admissionDate;
    private LocalDate terminationDate;

    public Employee() {
        super("EMPLOYEE");
    }

    public Employee(
            int userId,
            String password,
            boolean locked,
            boolean enabled,
            String name,
            String rg,
            String cpf,
            String phone,
            Address address,
            String position,
            String department,
            String email,
            String phoneExt,
            BigDecimal salary,
            EmployeeStatus status,
            LocalDate admissionDate,
            LocalDate terminationDate
    ) {
        super(userId, password, "EMPLOYEE", locked, enabled);
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phoneExt = phoneExt;
        this.salary = salary;
        this.status = status;
        this.admissionDate = admissionDate;
        this.terminationDate = terminationDate;
    }
    public Employee(
            String password,
            boolean locked,
            boolean enabled,
            String name,
            String rg,
            String cpf,
            String phone,
            Address address,
            String position,
            String department,
            String email,
            String phoneExt,
            BigDecimal salary,
            EmployeeStatus status,
            LocalDate admissionDate,
            LocalDate terminationDate
    ) {
        super(password, "EMPLOYEE", locked, enabled);
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phoneExt = phoneExt;
        this.salary = salary;
        this.status = status;
        this.admissionDate = admissionDate;
        this.terminationDate = terminationDate;
    }

}
