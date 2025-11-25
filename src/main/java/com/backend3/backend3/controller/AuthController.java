package com.backend3.backend3.controller;

import com.backend3.backend3.dto.LoginRequest;
import com.backend3.backend3.dto.LoginResponse;
import com.backend3.backend3.entity.Usuario;
import com.backend3.backend3.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.registrar(usuario);
        return ResponseEntity.ok(nuevo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioService.login(request.getEmail(), request.getPassword());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(401)
                    .body(new LoginResponse(null, null, null, null, "Credenciales inválidas"));
        }

        Usuario u = usuarioOpt.get();

        LoginResponse response = new LoginResponse(
                u.getId(),
                u.getNombre(),
                u.getEmail(),
                u.getTipoUsuario().name(),
                "Login exitoso"
        );

        return ResponseEntity.ok(response);
    }
}
