package com.example.institutocursos.Repository;

import com.example.institutocursos.Entity.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}
