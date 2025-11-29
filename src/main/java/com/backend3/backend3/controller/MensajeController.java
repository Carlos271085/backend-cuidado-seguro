package com.backend3.backend3.controller;

import com.backend3.backend3.dto.MensajeRequest;
import com.backend3.backend3.entity.Mensaje;
import com.backend3.backend3.service.MensajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    // ============================================================
    // LISTAR MENSAJES POR PACIENTE (GET)
    // ============================================================
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Mensaje>> listarPorPaciente(
            @PathVariable("pacienteId") Long pacienteId) {

        List<Mensaje> mensajes = mensajeService.listarPorPaciente(pacienteId);

        if (mensajes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(mensajes);
    }

    // ============================================================
    // ENVIAR MENSAJE (POST)
    // ============================================================
    @PostMapping
    public ResponseEntity<Mensaje> enviarMensaje(@RequestBody MensajeRequest request) {

        // Validación simple
        if (request.getPacienteId() == null ||
                request.getRemitenteId() == null ||
                request.getTexto() == null ||
                request.getTexto().isBlank()) {

            return ResponseEntity.badRequest().build();
        }

        Mensaje mensaje = mensajeService.enviarMensaje(
                request.getPacienteId(),
                request.getRemitenteId(),
                request.getAsunto(),
                request.getTexto()
        );

        return ResponseEntity.ok(mensaje);
    }
}
