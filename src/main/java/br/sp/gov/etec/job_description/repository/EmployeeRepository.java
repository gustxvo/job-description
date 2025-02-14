package br.sp.gov.etec.job_description.repository;

import br.sp.gov.etec.job_description.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "select * from tb_employees e where CONCAT(e.employee_id, e.name, e.ou_dep) " +
            "like %:keyword%", nativeQuery = true)
    List<Employee> searchEmployees(@Param("keyword") String keyword);

    @Query(value = "select name from tb_department e where position_holder = :user_id", nativeQuery = true)
    String findOuArea(@Param("user_id") String id);

    @Query(value = "select ou from tb_department e where position_holder = :user_id", nativeQuery = true)
    String findDepartmentByEmployee(@Param("user_id") String id);

    @Query(value = "select acronym from tb_sub_department e where position_holder = :user_id", nativeQuery = true)
    String findOuAcronym(@Param("user_id") String id);

    @Query(value = "select name_pt_br from tb_sub_department e where position_holder = :user_id", nativeQuery = true)
    String findOuNamePtBr(@Param("user_id") String id);

    @Query(value = "select name_en from tb_sub_department e where position_holder = :user_id", nativeQuery = true)
    String findOuNameEn(@Param("user_id") String id);
}
