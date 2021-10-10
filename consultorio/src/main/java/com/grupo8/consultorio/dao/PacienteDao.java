package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medico;
import com.grupo8.consultorio.models.Paciente;

import java.util.List;

public interface PacienteDao {
    List<Paciente> getAll();
    Paciente getById(int id);
    void insert(Paciente paciente);
    void edit(Paciente paciente, int id);
    void delete(int id);
}
