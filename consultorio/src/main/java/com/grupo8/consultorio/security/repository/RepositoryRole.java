package com.grupo8.consultorio.security.repository;

import com.grupo8.consultorio.security.entity.Role;
import com.grupo8.consultorio.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
