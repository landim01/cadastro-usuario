package com.landim001.cadastro_usuario.controller;

import com.landim001.cadastro_usuario.business.DisponibilidadeService;
import com.landim001.cadastro_usuario.business.model.Disponibilidade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
@RequiredArgsConstructor
public class DisponibilidadeController {

    private final DisponibilidadeService disponibilidadeService;

    @PostMapping
    public ResponseEntity<Disponibilidade> criar(@RequestBody Disponibilidade disponibilidade) {
        Disponibilidade salvo = disponibilidadeService.salvar(disponibilidade);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Disponibilidade>> listar() {
        return ResponseEntity.ok(disponibilidadeService.listarTodas());
    }

    @GetMapping("/livres")
    public ResponseEntity<List<Disponibilidade>> listarLivres() {
        return ResponseEntity.ok(disponibilidadeService.listarLivres());
    }

    @GetMapping("/psicologo/{id}")
    public ResponseEntity<List<Disponibilidade>> listarPorPsicologo(@PathVariable Integer id) {
        return ResponseEntity.ok(disponibilidadeService.listarPorPsicologo(id));
    }
}
