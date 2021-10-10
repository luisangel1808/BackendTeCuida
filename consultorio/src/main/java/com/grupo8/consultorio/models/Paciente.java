package com.grupo8.consultorio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod")
    private int cod;
    @Column(name="nombre_apellido")
    private String nombreApellido;
    @Column(name="telefono")
    private String telefono;
    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name="direccion")
    private String direccion;
    @Column(name="eps")
    private String eps;
    @Column(name="id_usuario")
    private int idUsuario;

    public Paciente(String nombreApellido, String telefono, LocalDate fechaNacimiento, String direccion, String eps, int idUsuario) {
        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.eps = eps;
        this.idUsuario = idUsuario;
    }
}
