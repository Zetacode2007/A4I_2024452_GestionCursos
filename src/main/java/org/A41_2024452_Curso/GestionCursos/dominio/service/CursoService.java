package org.A41_2024452_Curso.GestionCursos.dominio.service;

import org.A41_2024452_Curso.GestionCursos.persistence.crud.CursoCrud;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService{
    @Autowired
    private CursoCrud crud;

    @Override
    public List<Cursos> listarCursos() {
        List<Cursos> cursos = crud.findAll();
        return cursos;
    }
}
