package com.somospnt.entrevistasreactivas.business.service;

import com.somospnt.entrevistasreactivas.domain.Usuario;
import com.somospnt.entrevistasreactivas.vo.SolicitudRegistroUsuarioVo;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Mono<Usuario> buscarPorNombre(String nombre);

    Mono<Usuario> registrarNuevoUsuario(SolicitudRegistroUsuarioVo solicitudRegistroUsuarioVo);
}
