package com.grupo8.consultorio.controllers;

import com.grupo8.consultorio.dao.MedicamentoCitaDao;
import com.grupo8.consultorio.models.Medicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MedicamentosCitasController {

    @Autowired
    MedicamentoCitaDao medicamentoCitaDao;

    @RequestMapping(value ="api/medicamentos-citas/guardar")
    @PostMapping
    public void insert(@RequestBody List<Medicamento> medicals, @RequestParam int appointment){
        medicamentoCitaDao.insertMedicalsToAppointment(medicals, appointment);
    }

    @RequestMapping(value ="api/cita/{id}/medicamentos")
    public void findMedicalsAppointment(@PathVariable int id){
        medicamentoCitaDao.findMedicalsByAppointment( id);
    }


}
