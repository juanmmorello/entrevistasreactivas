package com.somospnt.entrevistasreactivas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    private String id;
    private String nombre;
    private String password;
    private String rol;
}
