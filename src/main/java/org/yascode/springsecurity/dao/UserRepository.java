package org.yascode.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yascode.springsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
