package com.landim001.cadastro_usuario.business.model;

import com.landim001.cadastro_usuario.infrastructure.entities.Usuario;
import jakarta.persistence.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "disponibilidade_id")
    private Disponibilidade disponibilidade;

    private String observacoes;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Usuario getPaciente() { return paciente; }
    public void setPaciente(Usuario paciente) { this.paciente = paciente; }

    public Disponibilidade getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(Disponibilidade disponibilidade) { this.disponibilidade = disponibilidade; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
