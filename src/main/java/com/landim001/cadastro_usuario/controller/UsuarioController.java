package com.landim001.cadastro_usuario.controller;

import com.landim001.cadastro_usuario.business.UsuarioService;
import com.landim001.cadastro_usuario.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // CREATE
    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        Usuario salvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(salvo);
    }

    // READ - listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    // READ - buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuario));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
