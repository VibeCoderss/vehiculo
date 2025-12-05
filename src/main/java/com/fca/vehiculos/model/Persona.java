package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Integer idPersona;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "primerapellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundoapellido",  nullable = true)
    private String segundoApellido;

}
