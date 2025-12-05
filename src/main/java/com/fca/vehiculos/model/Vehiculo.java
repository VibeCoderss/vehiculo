package com.fca.vehiculos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehiculo")
    private Integer idVehiculo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "preciolista", nullable = false)
    private Double precioLista;

    @Column(name = "matricula", nullable = true)
    private String matricula;

    @Column(name = "condicion", nullable = true)
    private String condicion;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

}
