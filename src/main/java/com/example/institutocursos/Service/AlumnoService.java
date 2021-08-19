package com.example.institutocursos.Service;

import com.example.institutocursos.Entity.Alumno;
import com.example.institutocursos.Repository.AlumnoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlumnoService {

    @Autowired
    public AlumnoRepository alumnoRepository;

    public AlumnoService() { }


    public Optional<Alumno> findById(String id) {
       return alumnoRepository.findById(id);
    }

    public Alumno save(Alumno alumno){
        return alumnoRepository.save(alumno);
    }



    public Alumno updateAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);

    }

    public void deleteAlumno(String id) {
        alumnoRepository.deleteById(id);

    }

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public List<Alumno> findByNameContaining(String name){
        return alumnoRepository.findByNameContaining(name);
    }

    public void deleteAll() {
        alumnoRepository.deleteAll();
    }
}



