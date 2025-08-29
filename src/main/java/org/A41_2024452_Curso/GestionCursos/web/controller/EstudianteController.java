package org.A41_2024452_Curso.GestionCursos.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.A41_2024452_Curso.GestionCursos.dominio.service.IEstudianteService;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiantes;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class EstudianteController {
    @Autowired
    IEstudianteService estudianteService;
    private List<Estudiantes> estudiantes;
    private Estudiantes estudianteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.estudiantes = this.estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.toString()));
    }

    public void agregarEstudiante(){
        this.estudianteSeleccionado = new Estudiantes();
    }

    public void guardarEstudiante(){
        if (this.estudianteSeleccionado.getId() == null){
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            this.estudiantes.add(this.estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Estudiante agregado correctamente: "));
        }else{
            this.estudianteService.guardarEstudiante(this.estudianteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiantes actualizado correctamente"));
        }
        PrimeFaces.current().executeScript("PF('ventanaModalEstudiante').hide()");
        PrimeFaces.current().ajax().update("formulario-estudiante:mensaje_emergente","formulario-estudiante:tabla-estudiante");
        this.estudianteSeleccionado = null;
    }

    public void eliminarEstudiante(){
        this.estudianteService.eliminarEstudiante(estudianteSeleccionado);
        this.estudiantes.remove(estudianteSeleccionado);
        this.estudianteSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudiante Eliminado con Exito!!"));
        PrimeFaces.current().ajax().update(
                "formulario-estudiante:mensaje_emergente","formulario-estudiante:tabla-estudiante");
    }

}
