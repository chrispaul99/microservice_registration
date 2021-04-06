package com.security.server.repository;

import java.util.Optional;

import com.common.entities.models.ERole;
import com.common.entities.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
