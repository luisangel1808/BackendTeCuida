/*
package com.grupo8.consultorio.util;

import com.grupo8.consultorio.security.entity.Role;
import com.grupo8.consultorio.security.enums.RoleName;
import com.grupo8.consultorio.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleDoctor = new Role(RoleName.ROLE_DOCTOR);
        roleService.save(roleAdmin);
        roleService.save(roleUser);
        roleService.save(roleDoctor);
    }
}*/