package com.landim001.cadastro_usuario.business;

import com.landim001.cadastro_usuario.infrastructure.entitys.HorarioDisponivel;
import com.landim001.cadastro_usuario.infrastructure.repository.HorarioDisponivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioService {

    private final HorarioDisponivelRepository repository;

    // Psicólogo adiciona horário livre usando SQL nativo
    public void adicionarHorarioLivre(Integer psicologoId, LocalDateTime dataHorario) {
        repository.inserirHorarioLivre(psicologoId, dataHorario);
    }

    // Paciente consulta todos os horários disponíveis usando SQL nativo
    public List<HorarioDisponivel> consultarHorariosDisponiveis() {
        return repository.findHorariosDisponiveis();
    }

    // Paciente consulta horários disponíveis de um psicólogo específico usando SQL nativo
    public List<HorarioDisponivel> consultarHorariosDisponiveisPorPsicologo(Integer psicologoId) {
        return repository.findHorariosDisponiveisPorPsicologo(psicologoId);
    }

    // Marcar horário como ocupado usando SQL nativo
    public void agendarHorario(Integer horarioId, Integer pacienteId) {
        int linhasAfetadas = repository.agendarHorario(horarioId, pacienteId);
        if (linhasAfetadas == 0) {
            throw new RuntimeException("Horário não encontrado ou já está ocupado");
        }
    }
}