package br.com.gustavoalmeidacarvalho.job_description.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@SuppressWarnings("LombokDataInspection")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "position_holder", nullable = false, length = 8)
//    private String holder;

    @Column(length = 50)
    private String company;

    @Column(name = "report_date", length = 10)
    private String report_date;

    @Column(name = "area", length = 200)
    private String area;

    @Column(name = "dep_acronym", length = 15)
    private String depAcronym;

    @Column(name = "ou_pt_br", length = 200)
    private String ouPt;

    @Column(name = "ou_en", length = 200)
    private String ouEn;

    @Column(name = "ou_number", length = 8)
    private String ouNumber;

    @Column(name = "ou_description")
    private String uoDescription;

    private String t1;

    @Column(name = "task_grade1", length = 30)
    private String taskGrade1;

    private String t2;

    @Column(name = "task_grade2", length = 30)
    private String taskGrade2;

    private String t3;

    @Column(name = "task_grade3", length = 30)
    private String taskGrade3;

    private String t4;

    @Column(name = "task_grade4", length = 30)
    private String taskGrade4;

    private String t5;

    @Column(name = "task_grade5", length = 30)
    private String taskGrade5;

    private String t6;

    @Column(name = "task_grade6", length = 30)
    private String taskGrade6;

    private String t7;

    @Column(name = "task_grade7", length = 30)
    private String taskGrade7;

    private String t8;

    @Column(name = "task_grade8", length = 30)
    private String taskGrade8;

    private String t9;

    @Column(name = "task_grade9", length = 30)
    private String taskGrade9;

    private String t10;

    @Column(name = "task_grade10", length = 30)
    private String taskGrade10;

    private String t11;

    @Column(name = "task_grade11", length = 30)
    private String taskGrade11;

    private String t12;

    @Column(name = "task_grade12", length = 30)
    private String taskGrade12;

    private String t13;

    @Column(name = "task_grade13", length = 30)
    private String taskGrade13;

    private String t14;

    @Column(name = "task_grade14", length = 30)
    private String taskGrade14;

    private String t15;

    @Column(name = "task_grade15", length = 30)
    private String taskGrade15;

    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;

    private String r1;
    private String r2;
    private String r3;
    private String r4;
    private String r5;

    @Column(length = 50)
    private String standard1;

    @Column(length = 50)
    private String standard2;

    private String c1;
    private String committee1;
    private String c2;
    private String committee2;
    private String c3;
    private String committee3;
    private String c4;
    private String committee4;
    private String c5;
    private String committee5;
    private String c6;
    private String committee6;
    private String c7;
    private String committee7;
    private String c8;
    private String committee8;
    private String c9;
    private String committee9;
    private String c10;
    private String committee10;

    @Column(name = "contact_points")
    private String contactPoints;

    @Column(name = "budget_euro", length = 20)
    private String budgetEuro;

    @Column(name = "budget_real", length = 20)
    private String budgetReal;

    @Column(name = "headcount_reference", length = 25)
    private String headcountReference;

    @Column(name = "management_ratio", length = 4)
    private String managementRatio;

    @Column(name = "third_parties", length = 4)
    private String thirdParties;

    private String kpi1;
    private String kpi2;

    @Column(name = "kpi1_value", length = 20)
    private String kpi1_value;

    @Column(name = "kpi2_value", length = 20)
    private String kpi2_value;

    @Column(name = "insert_unit", length = 50)
    private String insertUnit;

    @Column(name = "report_disc", length = 8)
    private String reportDisc;

    @Column(name = "report_function", length = 8)
    private String reportFunction;

    private String substitution1;
    private String substitution2;
    private String substitution3;
    private String substitution4;

    @Column(name = "signature_date", length = 10)
    private String signatureDate;
}
