package org.A41_2024452_Curso.GestionCursos.persistence.crud;

import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCrud extends JpaRepository<Estudiantes, Integer> {
}
