package com.backend3.backend3.service;

import com.backend3.backend3.entity.Paciente;
import com.backend3.backend3.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente crear(Paciente paciente) {
        // Podrías validar RUT único
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> actualizar(Long id, Paciente datos) {
        return pacienteRepository.findById(id).map(p -> {
            p.setRut(datos.getRut());
            p.setNombreCompleto(datos.getNombreCompleto());
            p.setEdad(datos.getEdad());
            p.setDiagnostico(datos.getDiagnostico());
            p.setAlergias(datos.getAlergias());
            p.setObservaciones(datos.getObservaciones());
            p.setCentro(datos.getCentro());
            p.setCiudad(datos.getCiudad());
            return pacienteRepository.save(p);
        });
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
