package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvendedor")
    private Integer idVendedor;

    @OneToOne
    @JoinColumn(name = "idpersona", unique = true, nullable = false)
    private Persona persona;

    @Column(name = "codigoempleado", nullable = false)
    private String codigoEmpleado;
}
