package com.backend3.backend3.repository;

import com.backend3.backend3.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByPacienteIdOrderByFechaDesc(Long pacienteId);
}
