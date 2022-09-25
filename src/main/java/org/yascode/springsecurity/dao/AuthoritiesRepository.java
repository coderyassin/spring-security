package org.yascode.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yascode.springsecurity.model.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
