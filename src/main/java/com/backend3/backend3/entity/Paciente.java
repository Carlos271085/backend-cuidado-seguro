package com.backend3.backend3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String rut;

    @Column(nullable = false, length = 120)
    private String nombreCompleto;

    private Integer edad;

    @Column(length = 200)
    private String diagnostico;

    @Column(length = 200)
    private String alergias;

    @Column(length = 300)
    private String observaciones;

    @Column(length = 120)
    private String centro;   // Ej: "ELEAM Alerces"

    @Column(length = 80)
    private String ciudad;   // Ej: "Viña del Mar"
}
