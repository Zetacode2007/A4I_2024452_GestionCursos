package org.A41_2024452_Curso.GestionCursos.dominio.service;

import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public List<Estudiante> listarEstudiantes();
    Estudiante buscarEstudiantePorId(Integer codigo);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Estudiante estudiante);
}
