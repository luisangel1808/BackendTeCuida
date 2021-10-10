package com.grupo8.consultorio.controllers;

import com.grupo8.consultorio.dao.MedicamentoDao;
import com.grupo8.consultorio.models.Medicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MedicamentosController {
    @Autowired
    private MedicamentoDao medicamentoDao;

    @RequestMapping(value ="api/medicamentos")
    public List<Medicamento> getAll(){
        return medicamentoDao.getAll();
    }

    @RequestMapping(value ="api/medicamentos/{id}")
    public Medicamento getById(@PathVariable int id){
        return medicamentoDao.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicamentos/create")
    @PostMapping
    public void insert(@RequestBody Medicamento medicamento){
        medicamentoDao.insert(medicamento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicamentos/delete/{id}")
    @DeleteMapping
    public void delete(@PathVariable int id){
        medicamentoDao.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/medicamentos/edit/{id}")
    @PutMapping
    public void edit(@RequestBody Medicamento medicamento, @PathVariable int id){
        medicamentoDao.edit(medicamento, id);
    }

}
