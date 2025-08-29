package org.A41_2024452_Curso.GestionCursos.dominio.service;

import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiantes;

import java.util.List;

public interface IEstudianteService {
    public List<Estudiantes> listarEstudiantes();
    Estudiantes buscarEstudiantePorId(Integer codigo);
    void guardarEstudiante(Estudiantes estudiante);
    void eliminarEstudiante(Estudiantes estudiante);
}
