package org.A41_2024452_Curso.GestionCursos.dominio.service;

import org.A41_2024452_Curso.GestionCursos.persistence.crud.EstudianteCrud;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private EstudianteCrud crud;

    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = crud.findAll();
        return estudiantes;
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer codigo) {
       Estudiante estudiante = crud.findById(codigo).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        crud.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        crud.delete(estudiante);
    }
}
