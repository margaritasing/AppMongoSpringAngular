/*package com.example.institutocursos.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Document(collection = "cursos")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cursos_id;
    private String nombre;
    private String carga;
    private String fechaContenido;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private List<Profesor> profesores;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
    private List<Alumno> alumnos;


    public Curso() {
    }

    public Curso(Integer cursos_id, String nombre, String carga, String fechaContenido, List<Profesor> profesores, List<Alumno> alumnos) {
        this.cursos_id = cursos_id;
        this.nombre = nombre;
        this.carga = carga;
        this.fechaContenido = fechaContenido;
        this.profesores = profesores;
        this.alumnos = alumnos;
    }

    public Integer getCursos_id() {
        return cursos_id;
    }

    public void setCursos_id(Integer cursos_id) {
        this.cursos_id = cursos_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public String getFechaContenido() {
        return fechaContenido;
    }

    public void setFechaContenido(String fechaContenido) {
        this.fechaContenido = fechaContenido;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}*/
