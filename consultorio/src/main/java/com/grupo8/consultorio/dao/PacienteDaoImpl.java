package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Paciente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PacienteDaoImpl implements PacienteDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Paciente> getAll() {
        String query ="FROM Paciente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Paciente getById(int id) {
        return entityManager.find(Paciente.class, id);
    }

    @Override
    public void insert(Paciente paciente) {
        entityManager.persist(paciente);
    }

    @Override
    public void edit(Paciente paciente, int id) {
        paciente.setCod(id);
        entityManager.merge(paciente);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Paciente.class, id));
    }
}
