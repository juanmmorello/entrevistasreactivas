package com.somospnt.entrevistasreactivas.business.service.impl;

import com.somospnt.entrevistasreactivas.business.service.UsuarioService;
import com.somospnt.entrevistasreactivas.domain.Rol;
import com.somospnt.entrevistasreactivas.domain.Usuario;
import com.somospnt.entrevistasreactivas.repository.UsuarioRepository;
import com.somospnt.entrevistasreactivas.utils.PasswordEncodingFactory;
import com.somospnt.entrevistasreactivas.vo.SolicitudRegistroUsuarioVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncodingFactory passwordEncoder;

    @Override
    public Mono<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public Mono<Usuario> registrarNuevoUsuario(SolicitudRegistroUsuarioVo solicitudRegistroUsuarioVo) {
        return usuarioRepository.save(
                Usuario.builder()
                        .nombre(solicitudRegistroUsuarioVo.getNombre())
                        .password(passwordEncoder.passwordEncoder().encode(solicitudRegistroUsuarioVo.getPassword()))
                        .roles(List.of(Rol.ROLE_USER)).build()
        );
    }
}
