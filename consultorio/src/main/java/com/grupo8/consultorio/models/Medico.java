package com.grupo8.consultorio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medicos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod")
    private int cod;
    @Column(name="nombre_apellido")
    private String nombre;
    @Column(name="consultorio")
    private int consultorio;
    @Column(name="id_usuario")
    private int idUsuario;

    public Medico(String nombre, int consultorio, int idUsuario) {
        this.nombre = nombre;
        this.consultorio = consultorio;
        this.idUsuario = idUsuario;
    }
}
