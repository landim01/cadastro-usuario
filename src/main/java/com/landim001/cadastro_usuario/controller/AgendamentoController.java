package com.landim001.cadastro_usuario.controller;

import com.landim001.cadastro_usuario.business.AgendamentoService;
import com.landim001.cadastro_usuario.business.model.Agendamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping("/{pacienteId}/{disponibilidadeId}")
    public ResponseEntity<Agendamento> agendar(
            @PathVariable Integer pacienteId,
            @PathVariable Integer disponibilidadeId,
            @RequestBody(required = false) String observacoes
    ) {
        Agendamento ag = agendamentoService.agendar(pacienteId, disponibilidadeId, observacoes);
        return ResponseEntity.ok(ag);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<Agendamento>> listarPorPaciente(@PathVariable Integer id) {
        return ResponseEntity.ok(agendamentoService.listarPorPaciente(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Integer id) {
        agendamentoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}
