package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medicamento;

import java.util.List;

public interface MedicamentoDao {
    List<Medicamento> getAll();
    Medicamento getById(int id);
    void insert(Medicamento medicamento);
    void edit(Medicamento medicamento, int id);
    void delete(int id);
}
