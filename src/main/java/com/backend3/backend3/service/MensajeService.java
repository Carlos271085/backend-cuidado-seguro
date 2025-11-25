package com.backend3.backend3.service;

import com.backend3.backend3.entity.Mensaje;
import com.backend3.backend3.entity.Paciente;
import com.backend3.backend3.entity.Usuario;
import com.backend3.backend3.repository.MensajeRepository;
import com.backend3.backend3.repository.PacienteRepository;
import com.backend3.backend3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeService {

    private final MensajeRepository mensajeRepository;
    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    public MensajeService(MensajeRepository mensajeRepository,
                          PacienteRepository pacienteRepository,
                          UsuarioRepository usuarioRepository) {
        this.mensajeRepository = mensajeRepository;
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Mensaje> listarPorPaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return mensajeRepository.findByPaciente(paciente);
    }

    public Mensaje enviarMensaje(Long pacienteId, Long remitenteId, String asunto, String contenido) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Usuario remitente = usuarioRepository.findById(remitenteId)
                .orElseThrow(() -> new RuntimeException("Remitente no encontrado"));

        Mensaje mensaje = new Mensaje();
        mensaje.setPaciente(paciente);
        mensaje.setRemitente(remitente);
        mensaje.setAsunto(asunto);
        mensaje.setContenido(contenido);
        mensaje.setFechaEnvio(LocalDateTime.now());

        return mensajeRepository.save(mensaje);
    }
}
