package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Cita;

import java.util.List;

public interface AppointmentDao {
    List<Cita> getAll();
    List<Cita> getByPatientId(int id);
    List<Cita> getAvailable();
    Cita getById(int id);
    void insert(Cita cita);
    void edit(Cita cita, int id);
    void delete(int id);
    void scheduleAppointment(String username, Cita cita);
}
