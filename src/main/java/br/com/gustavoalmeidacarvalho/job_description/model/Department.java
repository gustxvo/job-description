package br.com.gustavoalmeidacarvalho.job_description.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@SuppressWarnings("LombokDataInspection")
@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_sub_department")
public class Department {

    @Id
    @Column(nullable = false, length = 8)
    private String ou;

    @Column(name = "name_en", nullable = false, length = 200)
    private String nameEn;

    @Column(name = "name_pt_br", nullable = false, length = 200)
    private String namePtBr;

    @Column(nullable = false, length = 45)
    private String acronym;

    @Column(name = "position_holder", length = 8)
    private String holder;

}
