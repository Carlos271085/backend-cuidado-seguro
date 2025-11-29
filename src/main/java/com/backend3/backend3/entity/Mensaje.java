package com.backend3.backend3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String asunto;   // Asunto del mensaje

    @Column(columnDefinition = "TEXT")
    private String texto;    // Cuerpo del mensaje

    @Column(name = "paciente_id", nullable = false)
    private Long pacienteId; // Paciente receptor

    @Column(name = "remitente_id", nullable = false)
    private Long remitenteId; // Tutor u otro usuario que envía

    private LocalDateTime fecha; // Se asigna en el service
}

