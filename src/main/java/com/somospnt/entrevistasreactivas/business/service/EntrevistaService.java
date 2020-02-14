package com.somospnt.entrevistasreactivas.business.service;

import com.somospnt.entrevistasreactivas.domain.Entrevista;
import reactor.core.publisher.Mono;

public interface EntrevistaService {
    Mono<Entrevista> guardarEntrevista(Entrevista entrevista);
}
