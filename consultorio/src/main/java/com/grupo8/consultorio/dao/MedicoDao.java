package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medico;

import java.util.List;

public interface MedicoDao {
    List<Medico> getAll();
    Medico getById(int id);
    void insert(Medico medico);
    void edit(Medico medico, int id);
    void delete(int id);
}
