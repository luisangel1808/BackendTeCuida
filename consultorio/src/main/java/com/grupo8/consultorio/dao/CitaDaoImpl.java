package com.grupo8.consultorio.dao;

import com.grupo8.consultorio.models.Cita;
import com.grupo8.consultorio.models.Paciente;
import com.grupo8.consultorio.security.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CitaDaoImpl implements AppointmentDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cita> getAll() {
        String query ="FROM Cita";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Cita> getByPatientId(int id) {
        String query = "FROM Cita WHERE cod_paciente = :cod_paciente";
        return entityManager.createQuery(query)
                .setParameter("cod_paciente", id)
                .getResultList();
    }

    @Override
    public List<Cita> getAvailable() {
        String query = "FROM Cita WHERE estado_cita = :estado_cita";
        return  entityManager.createQuery(query)
                .setParameter("estado_cita", 0)
                .getResultList();

    }

    @Override
    public Cita getById(int id) {
        return entityManager.find(Cita.class, id);
    }
    @Override
    public void insert(Cita cita) {
        entityManager.persist(cita);
    }

    @Override
    public void edit(Cita cita, int id) {
        cita.setCodCita(id);
        entityManager.merge(cita);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Cita.class, id));
    }

    @Override
    public void scheduleAppointment(String username, Cita cita) {
        String query = "FROM User WHERE user_name = :user_name";
        User user = (User) entityManager.createQuery(query)
                .setParameter("user_name", Integer.valueOf(username))
                .getResultList().get(0);
        String query2 = "FROM Paciente WHERE id_usuario = :id_usuario";
        Paciente paciente = (Paciente) entityManager.createQuery(query)
                .setParameter("id_usuario", user.getId())
                .getResultList().get(0);
        edit(cita, paciente.getCod());
    }
}
