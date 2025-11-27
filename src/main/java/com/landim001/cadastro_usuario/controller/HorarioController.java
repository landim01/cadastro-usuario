package com.landim001.cadastro_usuario.controller;

import com.landim001.cadastro_usuario.business.HorarioService;
import com.landim001.cadastro_usuario.infrastructure.entitys.HorarioDisponivel;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/horarios")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    // Rota 1: Psicólogo adiciona horário livre
    @PostMapping("/psicologo/{psicologoId}")
    public ResponseEntity<Void> adicionarHorarioLivre(
            @PathVariable Integer psicologoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHorario) {

        horarioService.adicionarHorarioLivre(psicologoId, dataHorario);
        return ResponseEntity.ok().build();
    }

    // Rota 2: Paciente consulta todos os horários disponíveis
    @GetMapping("/disponiveis")
    public ResponseEntity<List<HorarioDisponivel>> consultarHorariosDisponiveis() {
        return ResponseEntity.ok(horarioService.consultarHorariosDisponiveis());
    }

    // Rota extra: Paciente consulta horários de um psicólogo específico
    @GetMapping("/disponiveis/psicologo/{psicologoId}")
    public ResponseEntity<List<HorarioDisponivel>> consultarHorariosDisponiveisPorPsicologo(
            @PathVariable Integer psicologoId) {

        return ResponseEntity.ok(horarioService.consultarHorariosDisponiveisPorPsicologo(psicologoId));
    }

    // Rota extra: Paciente agenda um horário
    @PostMapping("/agendar/{horarioId}")
    public ResponseEntity<Void> agendarHorario(
            @PathVariable Integer horarioId,
            @RequestParam Integer pacienteId) {

        horarioService.agendarHorario(horarioId, pacienteId);
        return ResponseEntity.ok().build();
    }
}