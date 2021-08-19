package com.example.institutocursos.Repository;

import com.example.institutocursos.Entity.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

    List<Alumno> findByNameContaining(String name);
}
