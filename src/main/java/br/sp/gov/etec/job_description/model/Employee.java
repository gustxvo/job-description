package br.sp.gov.etec.job_description.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("LombokDataInspection")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_employees")
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false, length = 8)
    private String employeeId;

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
}
