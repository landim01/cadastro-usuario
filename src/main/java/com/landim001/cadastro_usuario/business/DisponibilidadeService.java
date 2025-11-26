package com.landim001.cadastro_usuario.business;

import com.landim001.cadastro_usuario.business.model.Disponibilidade;
import com.landim001.cadastro_usuario.infrastructure.repositories.DisponibilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;

    public Disponibilidade salvar(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    public List<Disponibilidade> listarTodas() {
        return disponibilidadeRepository.findAll();
    }

    public List<Disponibilidade> listarPorPsicologo(Integer psicologoId) {
        return disponibilidadeRepository.findByPsicologoId(psicologoId);
    }

    public List<Disponibilidade> listarLivres() {
        return disponibilidadeRepository.findByLivreTrue();
    }
}
