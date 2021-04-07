package com.security.server.repository;

import java.util.Optional;

import com.common.entities.models.ERole;
import com.common.entities.models.Role;
import com.security.server.models.RoleData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<RoleData, Long> {
	Optional<RoleData> findByName(ERole name);
}
