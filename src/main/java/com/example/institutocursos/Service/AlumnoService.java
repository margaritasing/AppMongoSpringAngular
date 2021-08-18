package com.example.institutocursos.Service;

import com.example.institutocursos.Dto.AlumnoDto;
import com.example.institutocursos.Entity.Alumno;
import com.example.institutocursos.Repository.AlumnoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlumnoService {

    @Autowired
    public AlumnoRepository alumnoRepository;

    public AlumnoService() { }

    public List<Alumno> getAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno getAlumno(String alumno_id) {
        Optional<Alumno> alumno = alumnoRepository.findById(alumno_id);
        return alumno.get();
    }

    public Alumno saveAlumno(AlumnoDto alumnoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Alumno alumno1 = modelMapper.map(alumnoDto, Alumno.class);
        return alumnoRepository.save(alumno1);
    }

    public Alumno updateAlumno(AlumnoDto alumnoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Alumno alumno = modelMapper.map(alumnoDto, Alumno.class);
        return alumnoRepository.save(alumno);
    }

    public String deleteAlumno(String alumno_id) {
        alumnoRepository.deleteById(alumno_id);
        return alumno_id;
    }
}



