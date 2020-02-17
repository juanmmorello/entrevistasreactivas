package com.somospnt.entrevistasreactivas.web.controller.rest;

import com.somospnt.entrevistasreactivas.business.service.UsuarioService;
import com.somospnt.entrevistasreactivas.domain.Usuario;
import com.somospnt.entrevistasreactivas.utils.PasswordEncodingFactory;
import com.somospnt.entrevistasreactivas.utils.JWTUtils;
import com.somospnt.entrevistasreactivas.vo.AuthRequestVo;
import com.somospnt.entrevistasreactivas.vo.AuthResponseVo;
import com.somospnt.entrevistasreactivas.vo.SolicitudRegistroUsuarioVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final PasswordEncodingFactory passwordEncoder;

    @PostMapping("/auth/login")
    public Mono<ResponseEntity<?>> login(@RequestBody AuthRequestVo authRequest) {
        return usuarioService.buscarPorNombre(authRequest.getNombre()).map((userDetails) -> {
//            passwordEncoder.passwordEncoder().encode(authRequest.getPassword()).equals(userDetails.getPassword())
            if (passwordEncoder.passwordEncoder().matches(authRequest.getPassword(), userDetails.getPassword())) {
                return ResponseEntity.ok(new AuthResponseVo(jwtUtils.generateToken(userDetails)));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

    }

    @PostMapping("/auth/register")
    public Mono<Usuario> registroNuevoUsuario(@RequestBody SolicitudRegistroUsuarioVo solicitudRegistroUsuario) {
        return this.usuarioService.registrarNuevoUsuario(solicitudRegistroUsuario);
    }
}
