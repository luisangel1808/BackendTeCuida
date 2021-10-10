package com.grupo8.consultorio.security.service;

import com.grupo8.consultorio.security.entity.Role;
import com.grupo8.consultorio.security.enums.RoleName;
import com.grupo8.consultorio.security.repository.RepositoryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RepositoryRole repositoryRole;

    public Optional<Role> findByRoleName(RoleName roleName){
        return repositoryRole.findByRoleName(roleName);
    }
    public void save(Role role){
        repositoryRole.save(role);
    }
}
