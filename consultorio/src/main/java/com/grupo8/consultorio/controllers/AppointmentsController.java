package com.grupo8.consultorio.controllers;
import com.grupo8.consultorio.dao.AppointmentDao;
import com.grupo8.consultorio.models.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentsController {
    @Autowired
    private AppointmentDao appointmentDao;


    @RequestMapping(value ="api/appointments")
    public List<Cita> getAll(){
        return appointmentDao.getAll();
    }

    @RequestMapping(value ="api/appointments/get-by-patient")
    @GetMapping
    public void getByPatientId(@RequestParam int id){
        appointmentDao.getByPatientId(id);
    }

    @RequestMapping(value ="api/appointments/available")
    @GetMapping
    public void getAvailable(@RequestParam int id){
        appointmentDao.getAvailable();
    }

    @RequestMapping(value ="api/appointments/{id}")
    public Cita getById(@PathVariable int id){
        return appointmentDao.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/appointments/create")
    @PostMapping
    public void insert(@RequestBody Cita cita){
        appointmentDao.insert(cita);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="api/appointments/delete/{id}")
    @DeleteMapping
    public void delete(@PathVariable int id){
        appointmentDao.delete(id);
    }

    @RequestMapping(value ="api/appointments/edit/{id}")
    @PutMapping
    public void edit(@RequestBody Cita cita, @PathVariable int id){
        appointmentDao.edit(cita, id);
    }

}
