package com.landim001.cadastro_usuario.infrastructure.repositories;

import com.landim001.cadastro_usuario.business.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByPacienteId(Integer pacienteId);
}
