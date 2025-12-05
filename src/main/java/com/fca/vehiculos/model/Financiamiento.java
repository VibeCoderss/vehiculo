package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financiamiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Financiamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfinanciamiento")
    private Integer idFinanciamiento;

    @OneToOne
    @JoinColumn(name = "idventa", unique = true, nullable = false)
    private Venta venta;

    @Column(name = "tasainteres", nullable = false)
    private Integer tasaInteres;

    @Column(name = "enganche", nullable = false)
    private Integer enganche;

    @Column(name = "plazo", nullable = false)
    private Integer plazo;

    @Column(name = "cuotamensual", nullable = false)
    private Integer cuotaMensual;

    @Enumerated(EnumType.STRING)
    private EstadoCredito estado;
}
