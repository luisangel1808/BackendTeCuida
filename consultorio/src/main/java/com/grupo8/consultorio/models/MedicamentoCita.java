package com.grupo8.consultorio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medicamento_cita")
@Data
@NoArgsConstructor
public class MedicamentoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod")
    private int cod;
    @Column(name="cod_cita")
    private int codCita;
    @Column(name="cod_medicamento")
    private int codMedicamento;

    public MedicamentoCita(int codCita, int codMedicamento) {
        this.codCita = codCita;
        this.codMedicamento = codMedicamento;
    }
}
