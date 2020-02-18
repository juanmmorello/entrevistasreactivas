package com.somospnt.entrevistasreactivas.business.service;

import com.somospnt.entrevistasreactivas.EntrevistasreactivasApplicationTests;
import com.somospnt.entrevistasreactivas.domain.Entrevista;
import com.somospnt.entrevistasreactivas.domain.Rol;
import com.somospnt.entrevistasreactivas.domain.Usuario;
import com.somospnt.entrevistasreactivas.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

public class EntrevistaServiceTests extends EntrevistasreactivasApplicationTests {

    @Autowired
    private EntrevistaService entrevistaService;
    private UsuarioRepository usuarioRepository;


    //    @Test
    public void guardarEntrevista_conParametrosValidos_DevuelveEntidadPersistida() {
//        Usuario usuario = generarUsuario();
        AtomicReference<Usuario> usuario = null;
        usuarioRepository.findByNombre("Algun nombre").subscribe(
                usuario::set
        );
        Entrevista entrevista = Entrevista.builder()
                .entrevistador(usuario.get())
                .entrevistado("Entrevistadito")
                .comentario("En la quinquela")
                .fecha(LocalDateTime.of(2020, 02, 14, 15, 00))
                .estaRealizada(false)
                .build();

        Entrevista entrevistaGuardada = entrevistaService.guardarEntrevista(entrevista).block();

        assertThat(entrevistaGuardada).isNotNull();
        assertThat(entrevistaGuardada.getEntrevistado()).isEqualTo(entrevista.getEntrevistado());
        assertThat(entrevistaGuardada.getComentario()).isEqualTo(entrevista.getComentario());
        assertThat(entrevistaGuardada.getEntrevistador()).isEqualTo(entrevista.getEntrevistador());
    }

    private Usuario generarUsuario() {
        return new Usuario("Algun id", "Algun nombre", "Alguna password", List.of(Rol.ROLE_USER));
    }
}
