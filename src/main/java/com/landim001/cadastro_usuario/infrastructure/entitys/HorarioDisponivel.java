package com.landim001.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "horario_disponivel")
@Entity
public class HorarioDisponivel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "psicologo_id")
    private Integer psicologoId;

    @Column(name = "data_horario")
    private LocalDateTime dataHorario;

    @Column(name = "disponivel")
    private Boolean disponivel;

    @Column(name = "paciente_id")
    private Integer pacienteId;
}