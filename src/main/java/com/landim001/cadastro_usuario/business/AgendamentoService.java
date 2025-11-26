package com.landim001.cadastro_usuario.business;

import com.landim001.cadastro_usuario.business.model.Agendamento;
import com.landim001.cadastro_usuario.business.model.Disponibilidade;
import com.landim001.cadastro_usuario.infrastructure.entities.Usuario;
import com.landim001.cadastro_usuario.infrastructure.repositories.AgendamentoRepository;
import com.landim001.cadastro_usuario.infrastructure.repositories.DisponibilidadeRepository;
import com.landim001.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final DisponibilidadeRepository disponibilidadeRepository;
    private final UsuarioRepository usuarioRepository;

    public Agendamento agendar(Integer pacienteId, Integer disponibilidadeId, String observacoes) {

        Usuario paciente = usuarioRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Disponibilidade disponibilidade = disponibilidadeRepository.findById(disponibilidadeId)
                .orElseThrow(() -> new RuntimeException("Disponibilidade não encontrada"));

        if (!disponibilidade.isLivre()) {
            throw new RuntimeException("Horário já está ocupado.");
        }

        // marcar como ocupado
        disponibilidade.setLivre(false);
        disponibilidadeRepository.save(disponibilidade);

        Agendamento ag = new Agendamento();
        ag.setPaciente(paciente);
        ag.setDisponibilidade(disponibilidade);
        ag.setObservacoes(observacoes);

        return agendamentoRepository.save(ag);
    }

    public List<Agendamento> listarPorPaciente(Integer pacienteId) {
        return agendamentoRepository.findByPacienteId(pacienteId);
    }

    public void cancelar(Integer agendamentoId) {

        Agendamento ag = agendamentoRepository.findById(agendamentoId)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        // liberar o horário novamente
        Disponibilidade disp = ag.getDisponibilidade();
        disp.setLivre(true);
        disponibilidadeRepository.save(disp);

        agendamentoRepository.delete(ag);
    }
}
