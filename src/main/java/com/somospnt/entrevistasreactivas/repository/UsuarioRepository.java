package com.somospnt.entrevistasreactivas.repository;

import com.somospnt.entrevistasreactivas.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
    Mono<Usuario> findByNombre(String nombre);
}
