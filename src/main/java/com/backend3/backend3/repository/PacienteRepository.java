package com.backend3.backend3.repository;

import com.backend3.backend3.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    boolean existsByRut(String rut);
}
