package com.example.institutocursos.Controller;

import com.example.institutocursos.Dto.AlumnoDto;
import com.example.institutocursos.Entity.Alumno;
import com.example.institutocursos.Links.AlumnoLinks;
import com.example.institutocursos.Service.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RepositoryRestController
@RequiredArgsConstructor
public class AlumnoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping(path = AlumnoLinks.ALUMNOS)
    public ResponseEntity<?> getAlumnos() {
        List<Alumno> alumnos = alumnoService.getAlumnos();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping(path = AlumnoLinks.ALUMNO)
    public ResponseEntity<?> getAlumno(@PathVariable("alumno_id") String alumno_id) {
        try {
            LOGGER.info("AlumnoController::: " + alumno_id);
            Alumno alumno = alumnoService.getAlumno(alumno_id);
            return ResponseEntity.ok(alumno);
        }catch (RuntimeException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @PostMapping(path = AlumnoLinks.CREATE_ALUMNO)
    public ResponseEntity<?> createAlumno(@RequestBody AlumnoDto alumnoDto) {
        LOGGER.info("AlumnoController: " + alumnoDto);
        Alumno alumno = alumnoService.saveAlumno(alumnoDto);
        return ResponseEntity.ok(alumno);
    }

    @PutMapping(path = AlumnoLinks.UPDATE_ALUMNO)
    public ResponseEntity<?> updateAlumno(@RequestBody AlumnoDto alumnoDto) {
        LOGGER.info("AlumnoController: " + alumnoDto);
        Alumno alumno = alumnoService.updateAlumno(alumnoDto);
        return ResponseEntity.ok(alumno);
    }

    @DeleteMapping(path = AlumnoLinks.DELETE_ALUMNO)
    public ResponseEntity<?> deleteAlumno(@PathVariable("alumno_id") String alumno_id) {
        LOGGER.info("AlumnoController: " + alumno_id);
        String result = alumnoService.deleteAlumno(alumno_id);
        return ResponseEntity.ok(result);
    }


}
