package com.EjercicioPractico1.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nombre;
    private String identificacion;
    private String nivel_cursando;
    private int edad;
    private double peso;
    private String genero;


    public Estudiante() {
    }

    public Estudiante(String estudiante,String nombre, String identificacion, String nivel_cursando, int edad, double peso, String genero, boolean activo) {
        this.nombre = estudiante;
        this.identificacion = identificacion;
        this.nivel_cursando = nivel_cursando;
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;

    }

}
