package com.somospnt.entrevistasreactivas.repository;

import com.somospnt.entrevistasreactivas.domain.Entrevista;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EntrevistaRepository extends ReactiveMongoRepository<Entrevista, String> {
    Flux<Entrevista> findByEntrevistadorNombre(String nombre);
}
