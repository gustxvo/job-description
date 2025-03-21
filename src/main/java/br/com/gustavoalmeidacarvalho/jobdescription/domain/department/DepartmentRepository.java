package br.com.gustavoalmeidacarvalho.jobdescription.domain.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findDepartmentByHolder_UserId(Integer employeeId);

}
