package com.example.institutocursos.Links;

import org.springframework.stereotype.Component;

@Component
public class AlumnoLinks {

    public static final String ALUMNOS = "/alumnos";
    public static final String ALUMNO = "/alumno/{alumno_id}";
    public static final String CREATE_ALUMNO = "/alumno";
    public static final String UPDATE_ALUMNO = "/alumno";
    public static final String DELETE_ALUMNO = "/alumno/{id}";
}
