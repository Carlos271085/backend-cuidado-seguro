package com.backend3.backend3.service;

import com.backend3.backend3.entity.TipoUsuario;
import com.backend3.backend3.entity.Usuario;
import com.backend3.backend3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrar(Usuario usuario) {
        // Aquí podrías validar que el email no exista ya
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> login(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getPassword().equals(password)) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> filtrarPorTipo(TipoUsuario tipo) {
        return usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getTipoUsuario() == tipo)
                .toList();
    }
}
