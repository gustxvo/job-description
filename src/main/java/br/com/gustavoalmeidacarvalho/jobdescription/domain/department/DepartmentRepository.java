package br.com.gustavoalmeidacarvalho.jobdescription.domain.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query(value = "select * from tb_sub_department dep where CONCAT(dep.ou, dep.acronym, dep.name_pt_br, dep.name_en, dep.position_holder)" +
            "like %:keyword%", nativeQuery = true)
    List<Department> searchDepartment(@Param("keyword") String keyword);
}
