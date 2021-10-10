package com.grupo8.consultorio.security.controller;

import com.grupo8.consultorio.dao.MedicoDao;
import com.grupo8.consultorio.dao.PacienteDao;
import com.grupo8.consultorio.models.Medico;
import com.grupo8.consultorio.models.Paciente;
import com.grupo8.consultorio.security.dto.JwtDto;
import com.grupo8.consultorio.security.dto.LoginUser;
import com.grupo8.consultorio.security.dto.NewUser;
import com.grupo8.consultorio.security.entity.Role;
import com.grupo8.consultorio.security.entity.User;
import com.grupo8.consultorio.security.enums.RoleName;
import com.grupo8.consultorio.security.jwt.JwtProvider;
import com.grupo8.consultorio.security.service.RoleService;
import com.grupo8.consultorio.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    PacienteDao pacienteDao;

    @Autowired
    MedicoDao medicoDao;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if (userService.existsByUserName(newUser.getName()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if (userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        String intRole = "";
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.findByRoleName(RoleName.ROLE_ADMIN).get());
        else if (newUser.getRoles().contains("doctor")) {
            roles.add(roleService.findByRoleName(RoleName.ROLE_DOCTOR).get());
            intRole = "D";
        } else {
            roles.add(roleService.findByRoleName(RoleName.ROLE_USER).get());
            intRole = "U";
        }
        user.setRoles(roles);
        int id = userService.save(user);

        if (intRole.equals("D")) {
            Medico medico = new Medico(newUser.getName(), newUser.getRoom(), id);
            medicoDao.insert(medico);
        }
        if (intRole.equals("U")) {
            Paciente paciente = new Paciente(newUser.getName(), newUser.getPhone(),
                    newUser.getBirthDate(), newUser.getAddress(), newUser.getEps(), id);
            pacienteDao.insert(paciente);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}
