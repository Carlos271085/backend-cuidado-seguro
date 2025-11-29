package com.backend3.backend3.dto;

import lombok.Data;

@Data
public class MensajeRequest {
    private Long pacienteId;
    private Long remitenteId;
    private String asunto;
    private String texto;
}
