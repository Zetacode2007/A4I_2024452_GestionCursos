package org.A41_2024452_Curso.GestionCursos.dominio.service;

import org.A41_2024452_Curso.GestionCursos.persistence.crud.EstudianteCrud;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private EstudianteCrud crud;

    @Override
    public List<Estudiantes> listarEstudiantes() {
        List<Estudiantes> estudiantes = crud.findAll();
        return estudiantes;
    }

    @Override
    public Estudiantes buscarEstudiantePorId(Integer codigo) {
       Estudiantes estudiante = crud.findById(codigo).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiantes estudiante) {
        crud.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiantes estudiante) {
        crud.delete(estudiante);
    }
}
