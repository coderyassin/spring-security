package org.yascode.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yascode.springsecurity.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
