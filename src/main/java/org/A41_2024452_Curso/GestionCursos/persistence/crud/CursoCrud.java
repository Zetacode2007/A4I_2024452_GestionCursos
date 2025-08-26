package org.A41_2024452_Curso.GestionCursos.persistence.crud;

import org.A41_2024452_Curso.GestionCursos.persistence.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoCrud extends JpaRepository<Cursos, Integer> {
}
