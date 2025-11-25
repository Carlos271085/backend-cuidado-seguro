package com.backend3.backend3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private Long id;
    private String nombre;
    private String email;
    private String tipoUsuario;
    private String mensaje;
}
