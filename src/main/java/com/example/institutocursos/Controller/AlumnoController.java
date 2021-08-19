package com.example.institutocursos.Controller;


import com.example.institutocursos.Entity.Alumno;
import com.example.institutocursos.Service.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestController
@RequiredArgsConstructor
public class AlumnoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoController.class);

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAllAlumno(@RequestParam(required = false) String name) {
        try {
            List<Alumno> alumnos= new ArrayList<>();
            if (name == null)
                alumnoService.findAll().forEach(alumnos::add);
            else
                alumnoService.findByNameContaining(name).forEach(alumnos::add);
            if (alumnos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> getTutorialById(@PathVariable("id") String id) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        if (alumno.isPresent()) {
            return new ResponseEntity<>(alumno.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<Alumno> createTutorial(@RequestBody Alumno alumno) {
        try {
            Alumno alumno1 = alumnoService.save(alumno);
            return new ResponseEntity<>(alumno1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> updateTutorial(@PathVariable("id") String id, @RequestBody Alumno alumno) {
        Optional<Alumno> alumnoData = alumnoService.findById(id);
        if (alumnoData.isPresent()) {
            Alumno _alumno = alumnoData.get();
            _alumno.setName(alumno.getName());
            _alumno.setDocuments(alumno.getDocuments());
            _alumno.setLastname(alumno.getLastname());
            return new ResponseEntity<>(alumnoService.updateAlumno(_alumno), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            alumnoService.deleteAlumno(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/alumnos")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            alumnoService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
