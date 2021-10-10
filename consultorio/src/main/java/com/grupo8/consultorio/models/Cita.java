package com.grupo8.consultorio.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="citas")
@Data
public class Cita {
    @Id
    @Column(name="cod_cita")
    private int codCita;
    @Column(name="cod_med_cita")
    private int codMedCita;
    @Column(name="cod_medico")
    private int codMedico;
    @Column(name="cod_paciente")
    private int codPaciente;
    @Column(name="cod_fecha_hora")
    private Date fechaHora;
    @Column(name="cod_estado_cita")
    private char estadoCita;
    @Column(name="cod_diagnostico")
    private String diagnostico;
    @Column(name="prescripcion")
    private String prescripcion;
}
