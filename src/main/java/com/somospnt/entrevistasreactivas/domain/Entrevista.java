package com.somospnt.entrevistasreactivas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrevista implements Serializable {

    @Id
    private String id;
    private Usuario entrevistador;
    private String entrevistado;
    private LocalDateTime fecha;
    private String comentario;
    private Boolean estaRealizada;
}
