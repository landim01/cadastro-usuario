package com.landim001.cadastro_usuario.infrastructure.repositories;

import com.landim001.cadastro_usuario.business.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Integer> {

    List<Disponibilidade> findByPsicologoId(Integer psicologoId);

    List<Disponibilidade> findByData(LocalDate data);

    List<Disponibilidade> findByLivreTrue();
}
