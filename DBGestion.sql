drop database if exists DBGestiosCursos;
create database DBGestiosCursos;
use DBGestiosCursos;

create table Curso (
	id_curso int not null auto_increment,
    nombre varchar(200),
    constraint pk_Curso primary key (id_curso)
);

create table Estudiantes(
	id int not null auto_increment,
    nombre varchar(250),
    apellido varchar(250),
    correo varchar(250),
    id_curso int,
    constraint pk_Estudiantes primary key (id),
    constraint fk_Estudiantes_Curso foreign key (id_curso)
		references Curso(id_curso)
);

insert into Curso (nombre)
	values 	('Informatica'),
			('Cocina'),
            ('Electronica');

select * from Curso;

insert into estudiantes (nombre, apellido, correo, id_curso)
	values 	('Pablo','Hernandez','phernandez-2024329@gmail.com',1),
			('Ana', 'Martínez', 'amartinez-2024330@gmail.com', 2),
			('Luis', 'Gómez', 'lgomez-2024331@gmail.com', 3),
			('Carla', 'Ruiz', 'cruiz-2024332@gmail.com', 1),
			('Javier', 'Fernández', 'jfernandez-2024333@gmail.com', 2),
			('Lucía', 'Torres', 'ltorres-2024334@gmail.com', 3),
			('Miguel', 'Sánchez', 'msanchez-2024335@gmail.com', 1),
			('Valeria', 'Díaz', 'vdiaz-2024336@gmail.com', 2),
			('Andrés', 'López', 'alopez-2024337@gmail.com', 3),
			('Sofía', 'Ramírez', 'sramirez-2024338@gmail.com', 1);
		
        select * from estudiantes;
