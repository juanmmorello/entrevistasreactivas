package com.somospnt.entrevistasreactivas.vo;

import com.somospnt.entrevistasreactivas.domain.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaRegistroUsuarioVo {
    private String usuario;
    private List<Rol> roles;
}
