   create table empleados (
       	id bigint not null auto_increment,
        apellido_materno varchar(255),
        apellido_paterno varchar(255),
        correo varchar(255),
        fecha_incorporacion timestamp,
        nombre varchar(255),
        rut varchar(255),
        primary key (id)
    );