package com.Practica3.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;
    private String especie;
    private String ubicacion;
    private String altura;
    private Long edad;
    private String rutaImagen;
    private boolean estadoVida;

    public Arbol() {
    }

    public Arbol(String especie, String ubicacion, String altura, Long edad, String rutaImagen, boolean estadoVida) {
        this.especie = especie;
        this.ubicacion = ubicacion;
        this.altura = altura;
        this.edad = edad;
        this.rutaImagen = rutaImagen;
        this.estadoVida = estadoVida;
    }
}