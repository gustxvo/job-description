package br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto {

    private String id;
    private String name;
    private String rg;
    private String cpf;
    private String phone;
    private AddressDto address;
    private String position;
    private String department;
    private String email;
    private String phoneExt;
    private BigDecimal salary;
    private EmployeeStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate terminationDate;

    public EmployeeDto() {
        this.address = new AddressDto();
        this.status = EmployeeStatus.ACTIVE;
    }

}
