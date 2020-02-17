package com.somospnt.entrevistasreactivas.web.controller.rest;

import com.somospnt.entrevistasreactivas.business.service.UsuarioService;
import com.somospnt.entrevistasreactivas.domain.Usuario;
import com.somospnt.entrevistasreactivas.utils.BCryptEncoder;
import com.somospnt.entrevistasreactivas.utils.JWTUtils;
import com.somospnt.entrevistasreactivas.vo.AuthRequestVo;
import com.somospnt.entrevistasreactivas.vo.AuthResponseVo;
import com.somospnt.entrevistasreactivas.vo.RespuestaRegistroUsuarioVo;
import com.somospnt.entrevistasreactivas.vo.SolicitudRegistroUsuarioVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final JWTUtils jwtUtils;
    private final UsuarioService usuarioService;
    private final BCryptEncoder passwordEncoder;

    @PostMapping("/auth/login")
    public Mono<ResponseEntity<?>> login(@RequestBody AuthRequestVo authRequest) {
        return usuarioService.buscarPorNombre(authRequest.getNombre()).map((userDetails) -> {
            if (passwordEncoder.passwordEncoder().encode(authRequest.getPassword()).equals(userDetails.getPassword())) {
                return ResponseEntity.ok(new AuthResponseVo(jwtUtils.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/auth/register")
    public Mono<RespuestaRegistroUsuarioVo> registroNuevoUsuario(@RequestBody SolicitudRegistroUsuarioVo solicitudRegistroUsuario) {
        Mono<Usuario> usuarioMono = this.usuarioService.registrarNuevoUsuario(solicitudRegistroUsuario);
        RespuestaRegistroUsuarioVo respuesta = null;
        usuarioMono.subscribe(usuario -> {
            respuesta.setUsuario(usuario.getNombre());
            respuesta.setRoles(usuario.getRoles());
        });
        return Mono.just(respuesta);
    }
}
