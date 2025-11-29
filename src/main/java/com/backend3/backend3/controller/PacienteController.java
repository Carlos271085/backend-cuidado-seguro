package com.backend3.backend3.controller;

import com.backend3.backend3.entity.Paciente;
import com.backend3.backend3.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    
    // LISTAR TODOS
    
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    
    // BUSCAR POR ID
    
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") Long id) {
        return pacienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    // CREAR
    
    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.crear(paciente));
    }

    
    // ACTUALIZAR
    
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(
            @PathVariable("id") Long id,
            @RequestBody Paciente datos) {

        return pacienteService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    // ELIMINAR
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
