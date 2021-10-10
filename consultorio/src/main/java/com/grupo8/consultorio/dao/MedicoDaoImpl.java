package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Medico;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MedicoDaoImpl implements MedicoDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medico> getAll() {
        String query ="FROM Medico";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Medico getById(int id) {
        return entityManager.find(Medico.class, id);
    }

    @Override
    public void insert(Medico medico) {
        entityManager.persist(medico);
    }

    @Override
    public void edit(Medico medico, int id) {
        medico.setCod(id);
        entityManager.merge(medico);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Medico.class, id));
    }
}
