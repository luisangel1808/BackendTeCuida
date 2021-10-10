package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medicamento;
import com.grupo8.consultorio.models.MedicamentoCita;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MedicamentoCitaImpl implements MedicamentoCitaDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Medicamento> findMedicalsByAppointment(int id) {
        String query ="FROM MedicamentoCita WHERE codCita="+id;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void insertMedicalsToAppointment(List<Medicamento> medicamentos, int id) {
        for (Medicamento medicamento: medicamentos){
            MedicamentoCita medicamentoCita = new MedicamentoCita(id, medicamento.getCod());
            entityManager.persist(medicamentoCita);
        }
    }
}
