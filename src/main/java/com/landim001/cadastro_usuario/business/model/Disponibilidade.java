package com.landim001.cadastro_usuario.business.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import com.landim001.cadastro_usuario.infrastructure.entities.Usuario;

@Entity
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private boolean livre = true;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Usuario psicologo;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFim() { return horaFim; }
    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }

    public boolean isLivre() { return livre; }
    public void setLivre(boolean livre) { this.livre = livre; }

    public Usuario getPsicologo() { return psicologo; }
    public void setPsicologo(Usuario psicologo) { this.psicologo = psicologo; }
}
