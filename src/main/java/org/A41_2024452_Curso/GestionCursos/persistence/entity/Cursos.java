package org.A41_2024452_Curso.GestionCursos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity (name = "Cursos")
//lombok
@Data  //genera los Setter y getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode//codigo de autenticacion de la entidad
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;// permite usar null en vez de 0
    @Column
    private String nombre;
}
