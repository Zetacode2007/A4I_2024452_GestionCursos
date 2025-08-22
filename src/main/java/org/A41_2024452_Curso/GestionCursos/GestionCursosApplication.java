package org.A41_2024452_Curso.GestionCursos;

import org.A41_2024452_Curso.GestionCursos.dominio.service.IEstudianteService;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GestionCursosApplication implements CommandLineRunner {

    @Autowired
    private IEstudianteService estudianteService;
    private static final Logger logger = LoggerFactory.getLogger(GestionCursosApplication.class);
    String sl = System.lineSeparator();

	public static void main(String[] args) {
        logger.info("Bienvenido, aqui inicia la gestion de alumnos al curso de Informatica");
        SpringApplication.run(GestionCursosApplication.class, args);
        logger.info("Aqui finaliza la gestion de alumnos");
	}

    @Override
    public void run(String... args) throws Exception {
        GestionEstudianteApp();
    }

    private void GestionEstudianteApp(){
        logger.info("Aplicacion de gestion de estudiantes");
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir){
            var opcion = mostrarMenu(consola);
            salir = ejecutarOpciones(consola, opcion);
            logger.info(sl);
        }
    }

    private int mostrarMenu(Scanner consola){
        logger.info("""
                \n Bienvendio a la Gestion de Estudiantes ¿Que desea hacer?
                1. Mostrar todos los Estudiantes
                2. Buscar Estudiante
                3. Modificar Estudiante
                4. Eliminar Estudiante
                """);
        var opcion = Integer.parseInt(consola.nextLine());
        return opcion;
    }

    private boolean ejecutarOpciones(Scanner consola, Integer opcion){
        var salir = false;
        switch (opcion){
            case 1 ->{
                logger.info(sl+"Listado de los Estudiantes cursando"+sl);
                List<Estudiante> clientes = estudianteService.listarEstudiantes();
                clientes.forEach( estudiante -> logger.info(estudiante.toString()+sl));
            }
            case 2 ->{
                logger.info(sl+"Buscar Cliente por su codigo"+sl);
                var codigo = Integer.parseInt(consola.nextLine());
                Estudiante estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null){
                    logger.info("Cliente encontrado con exito: " +sl+ estudiante +sl);
                }else{
                    logger.info("Cliente no encontrado"+sl+ estudiante +sl);
                }
            }
        }
        return salir;
    }

}
