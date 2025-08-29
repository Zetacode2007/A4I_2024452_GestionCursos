package org.A41_2024452_Curso.GestionCursos;

import org.A41_2024452_Curso.GestionCursos.dominio.service.ICursoService;
import org.A41_2024452_Curso.GestionCursos.dominio.service.IEstudianteService;
import org.A41_2024452_Curso.GestionCursos.persistence.entity.Estudiantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class GestionCursosApplication implements CommandLineRunner {

    @Autowired
    private IEstudianteService estudianteService;
    private ICursoService cursoService;
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
                5. Agregar Estudiante
                6. Listar Cursos
                7. Salir
                """);
        var opcion = Integer.parseInt(consola.nextLine());
        return opcion;
    }

    private boolean ejecutarOpciones(Scanner consola, Integer opcion){
        var salir = false;
        switch (opcion){
            case 1 ->{
                logger.info(sl+"Listado de los Estudiantes cursando"+sl);
                List<Estudiantes> clientes = estudianteService.listarEstudiantes();
                clientes.forEach( estudiante -> logger.info(estudiante.toString()+sl));
            }
            case 2 ->{
                logger.info(sl+"Buscar Estudiante por su codigo"+sl);
                logger.info(sl+"Ingres el id del Alumno que desea buscar: "+sl);
                var codigo = Integer.parseInt(consola.nextLine());
                Estudiantes estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null){
                    logger.info("Estudiante encontrado con exito: " +sl+ estudiante +sl);
                }else{
                    logger.info("Estudiante no encontrado"+sl+ estudiante +sl);
                }
            }
            case 3 ->{
                logger.info(sl+"Modificar Alumno: "+sl);
                logger.info(sl+"Ingrese el codigo del Alumno a modificar"+sl);
                var codigo = Integer.parseInt(consola.nextLine());
                Estudiantes estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null){
                    logger.info("Ingrese el nombre: ");
                    var nombre = consola.nextLine();
                    logger.info("Ingrese el apellido: ");
                    var apellido = consola.nextLine();
                    logger.info("Ingrese el correo: ");
                    var correo = consola.nextLine();
                    estudiante.setNombre(nombre);
                    estudiante.setApellido(apellido);
                    estudiante.setCorreo(correo);
                    estudianteService.guardarEstudiante(estudiante);
                    logger.info(sl+"Estudiante editado correctamente: "+sl);
                }else {
                    logger.info(sl+"Estudiante no encontrado "+sl);
                }
            }
            case 4 -> {
                logger.info(sl+"Eliminar Cliente"+sl);
                logger.info("Ingrese el código del Estudiante a eliminar");
                var codigo = Integer.parseInt(consola.nextLine());
                var estudiante = estudianteService.buscarEstudiantePorId(codigo);
                if (estudiante != null){
                    estudianteService.eliminarEstudiante(estudiante);
                    logger.info("Estudiante eliminado correctamente"+sl+ estudiante +sl);
                }else {
                    logger.info("Estudiante no encontrado"+sl+ estudiante +sl);
                }
            }
            case 5 ->{
                logger.info(sl + "Agregar Nuevo Alumno: " + sl);
                logger.info(sl+"Ingrese el nombre: "+sl);
                var nombre = consola.nextLine();
                logger.info(sl+"Ingrese el apellido: "+sl);
                var apellido = consola.nextLine();
                logger.info(sl+"Ingrese el correo: "+sl);
                var correo = consola.nextLine();
                Estudiantes nuevoEstudiante = new Estudiantes();
                nuevoEstudiante.setNombre(nombre);
                nuevoEstudiante.setApellido(apellido);
                nuevoEstudiante.setCorreo(correo);
                estudianteService.guardarEstudiante(nuevoEstudiante);
                logger.info(sl + "Estudiante agregado correctamente" + sl);

            }
            case 7 ->{
                logger.info(sl+"Saliendo..."+sl);
                salir = true;
            }
            default -> logger.info("Opcion no valida!!!");
        }
        return salir;
    }

}
