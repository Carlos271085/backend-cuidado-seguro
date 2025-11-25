package com.backend3.backend3.controller;

import com.backend3.backend3.entity.Mensaje;
import com.backend3.backend3.service.MensajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    private final MensajeService mensajeService;

    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Mensaje>> listarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(mensajeService.listarPorPaciente(pacienteId));
    }

    @PostMapping
    public ResponseEntity<Mensaje> enviarMensaje(@RequestBody Map<String, Object> body) {
        Long pacienteId = Long.valueOf(body.get("pacienteId").toString());
        Long remitenteId = Long.valueOf(body.get("remitenteId").toString());
        String asunto = body.get("asunto").toString();
        String contenido = body.get("contenido").toString();

        Mensaje mensaje = mensajeService.enviarMensaje(pacienteId, remitenteId, asunto, contenido);
        return ResponseEntity.ok(mensaje);
    }
}
