package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontado")
    private Integer idContado;

    @OneToOne
    @JoinColumn(name = "idventa", unique = true, nullable = false)
    private Venta venta;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
}
