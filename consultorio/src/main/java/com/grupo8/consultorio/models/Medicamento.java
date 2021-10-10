package com.grupo8.consultorio.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamentos")
@Data
public class Medicamento {
    @Id
    @Column(name="cod")
    private int cod;
    @Column(name="nombre")
    private String nombre;
    @Column(name="estado")
    private char estado;
}
