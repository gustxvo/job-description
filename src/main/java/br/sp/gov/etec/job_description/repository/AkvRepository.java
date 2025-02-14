package br.sp.gov.etec.job_description.repository;

import br.sp.gov.etec.job_description.model.Akv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkvRepository extends CrudRepository<Akv, Long> {

//    @Query(value = "select ou, name from tb_sub_department e where position_holder = :user_id", nativeQuery = true)
//    AkvForm findDepartmentByEmployee(@Param("user_id") String id);
}
