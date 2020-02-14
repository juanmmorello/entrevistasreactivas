package com.somospnt.entrevistasreactivas.repository;

import com.somospnt.entrevistasreactivas.domain.Entrevista;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EntrevistaRepository extends ReactiveMongoRepository<Entrevista, Long> {

}
