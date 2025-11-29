package com.backend3.backend3.service;

import com.backend3.backend3.entity.Mensaje;
import com.backend3.backend3.repository.MensajeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    // ============================================================
    // LISTAR TODOS LOS MENSAJES DE UN PACIENTE
    // ============================================================
    public List<Mensaje> listarPorPaciente(Long pacienteId) {
        return mensajeRepository.findByPacienteIdOrderByFechaDesc(pacienteId);
    }

    // ============================================================
    // ENVIAR MENSAJE DESDE TUTOR (o profesional) → PACIENTE
    // ============================================================
    public Mensaje enviarMensaje(Long pacienteId, Long remitenteId, String asunto, String texto) {

        Mensaje mensaje = new Mensaje();

        mensaje.setPacienteId(pacienteId);
        mensaje.setRemitenteId(remitenteId);
        mensaje.setAsunto(asunto);
        mensaje.setTexto(texto);

        // Fecha del mensaje
        mensaje.setFecha(LocalDateTime.now());

        return mensajeRepository.save(mensaje);
    }
}
