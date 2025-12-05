package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer idCliente;

    @OneToOne
    @JoinColumn(name = "idpersona", unique = true, nullable = false)
    private Persona persona;

    @Column(name = "rfc", nullable = false)
    private String rfc;

    @Column(name = "telefono", nullable = true)
    private String telefono;

    @Column(name = "correo", nullable = true)
    private String correo;

}
