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

    // Paciente al que se refiere el mensaje
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Usuario que envía el mensaje (Tutor o Profesional)
    @ManyToOne(optional = false)
    @JoinColumn(name = "remitente_id")
    private Usuario remitente;

    @Column(nullable = false, length = 150)
    private String asunto;

    @Column(nullable = false, length = 1000)
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fechaEnvio;
}
