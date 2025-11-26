package com.landim001.cadastro_usuario.business;

import com.landim001.cadastro_usuario.infrastructure.entities.Usuario;
import com.landim001.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // CREATE
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // READ - listar todos
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // READ - buscar por ID
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    // UPDATE
    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());

        return usuarioRepository.save(usuario);
    }

    // DELETE
    public void deletarUsuario(Integer id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}
