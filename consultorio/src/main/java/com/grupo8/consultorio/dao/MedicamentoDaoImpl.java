package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medicamento;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MedicamentoDaoImpl implements MedicamentoDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medicamento> getAll() {
        String query ="FROM Medicamento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Medicamento getById(int id) {
        return entityManager.find(Medicamento.class, id);
    }

    @Override
    public void insert(Medicamento medicamento) {
        entityManager.persist(medicamento);
    }

    @Override
    public void edit(Medicamento medicamento, int id) {
        medicamento.setCod(id);
        entityManager.merge(medicamento);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Medicamento.class, id));
    }
}
