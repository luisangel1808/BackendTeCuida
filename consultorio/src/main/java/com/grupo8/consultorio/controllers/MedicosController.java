package com.grupo8.consultorio.controllers;

import com.grupo8.consultorio.dao.MedicoDao;
import com.grupo8.consultorio.models.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MedicosController {
    @Autowired
    private MedicoDao medicoDao;


    @RequestMapping(value ="api/medicos")
    public List<Medico> getAll(){
        return medicoDao.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicos/{id}")
    public Medico getById(@PathVariable int id){
        return medicoDao.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicos/create")
    @PostMapping
    public void insert(@RequestBody Medico medico){
        medicoDao.insert(medico);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicos/delete/{id}")
    @DeleteMapping
    public void delete(@PathVariable int id){
        medicoDao.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicos/edit/{id}")
    @PutMapping
    public void edit(@RequestBody Medico medico, @PathVariable int id){
        medicoDao.edit(medico, id);
    }
}
