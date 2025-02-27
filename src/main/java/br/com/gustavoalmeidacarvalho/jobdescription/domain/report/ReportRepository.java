package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

//    @Query(value = "select ou, name from tb_sub_department e where position_holder = :user_id", nativeQuery = true)
//    AkvForm findDepartmentByEmployee(@Param("user_id") String id);
}
