package com.somospnt.entrevistasreactivas.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRegistroUsuarioVo {
    private String nombre;
    private String password;
}
