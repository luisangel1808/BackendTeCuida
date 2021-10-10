package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medicamento;

import java.util.List;

public interface MedicamentoCitaDao {
    List<Medicamento> findMedicalsByAppointment(int id);
    void insertMedicalsToAppointment(List<Medicamento> medicamentos, int id);
}
