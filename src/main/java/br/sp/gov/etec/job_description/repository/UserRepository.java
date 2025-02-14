package br.sp.gov.etec.job_description.repository;

import br.sp.gov.etec.job_description.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId (String userId);
}
