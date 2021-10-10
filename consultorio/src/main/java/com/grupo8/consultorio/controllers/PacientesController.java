package com.grupo8.consultorio.controllers;

import com.grupo8.consultorio.dao.PacienteDao;
import com.grupo8.consultorio.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PacientesController {
    @Autowired
    private PacienteDao pacienteDao;

    @RequestMapping(value ="api/pacientes")
    public List<Paciente> getAll(){
        return pacienteDao.getAll();
    }

    @RequestMapping(value ="api/pacientes/{id}")
    public Paciente getById(@PathVariable int id){
        return pacienteDao.getById(id);
    }

    @RequestMapping(value ="api/pacientes/create")
    @PostMapping
    public void insert(@RequestBody Paciente paciente){
        pacienteDao.insert(paciente);
    }

    @RequestMapping(value ="api/pacientes/delete/{id}")
    @DeleteMapping
    public void delete(@PathVariable int id){
        pacienteDao.delete(id);
    }

    @RequestMapping(value ="api/pacientes/edit/{id}")
    @PutMapping
    public void edit(@RequestBody Paciente player, @PathVariable int id){
        pacienteDao.edit(player, id);
    }
}
