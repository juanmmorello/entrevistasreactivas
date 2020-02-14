package com.somospnt.entrevistasreactivas.business.service.impl;

import com.somospnt.entrevistasreactivas.business.service.EntrevistaService;
import com.somospnt.entrevistasreactivas.domain.Entrevista;
import com.somospnt.entrevistasreactivas.repository.EntrevistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EntrevistaServiceImpl implements EntrevistaService {

    private final EntrevistaRepository entrevistaRepository;

    @Override
    public Mono<Entrevista> guardarEntrevista(Entrevista entrevista) {
        return entrevistaRepository.save(entrevista);
    }
}
