package com.landim001.cadastro_usuario.infrastructure.repository;

import com.landim001.cadastro_usuario.infrastructure.entitys.HorarioDisponivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface HorarioDisponivelRepository extends JpaRepository<HorarioDisponivel, Integer> {

    // SQL NATIVO - Buscar todos os horários disponíveis
    @Query(value = "SELECT * FROM horario_disponivel WHERE disponivel = true", nativeQuery = true)
    List<HorarioDisponivel> findHorariosDisponiveis();

    // SQL NATIVO - Buscar horários disponíveis por psicólogo
    @Query(value = "SELECT * FROM horario_disponivel WHERE psicologo_id = :psicologoId AND disponivel = true", nativeQuery = true)
    List<HorarioDisponivel> findHorariosDisponiveisPorPsicologo(@Param("psicologoId") Integer psicologoId);

    // SQL NATIVO - Inserir horário (INSERT direto)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO horario_disponivel (id, psicologo_id, data_horario, disponivel, paciente_id) VALUES (NEXT VALUE FOR horario_disponivel_seq, :psicologoId, :dataHorario, true, null)", nativeQuery = true)
    void inserirHorarioLivre(@Param("psicologoId") Integer psicologoId, @Param("dataHorario") LocalDateTime dataHorario);

    // SQL NATIVO - Atualizar horário para ocupado
    @Modifying
    @Transactional
    @Query(value = "UPDATE horario_disponivel SET disponivel = false, paciente_id = :pacienteId WHERE id = :horarioId AND disponivel = true", nativeQuery = true)
    int agendarHorario(@Param("horarioId") Integer horarioId, @Param("pacienteId") Integer pacienteId);
}