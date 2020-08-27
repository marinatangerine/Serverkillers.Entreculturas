-- drop database ONG;
create database ONG;

-- drop table sede;
create table sede (
idSede int not null,
ciudad varchar(100),
direccion varchar(255),
telefono varchar(50),
email varchar (50),

primary key (idSede)
);

-- drop table proyecto;
create table proyecto (
codProyecto int not null,
nombre varchar(100),
lineaAccion varchar(255),
subLinea varchar(255),
pais varchar(50),
localizacion varchar(100),
fechaInicio date,
fechaFin date, 
acciones varchar(255),
fk_sedeProyecto int,

primary key (codProyecto)
);

-- drop table persona;
create table persona (
personId int not null,
userName varchar(50),
pass varchar(10),
administrator bool,
namePersona varchar (100),
surname varchar(100),
address varchar(255),
phone varchar(50),
email varchar(50),
fk_sedePersona int,

primary key (personId)
);

-- drop table voluntario;
create table voluntario (
idVoluntario int not null,
areaActividades varchar(255),
userName varchar(50),
pass varchar(10),
administrator bool,
namePersona varchar (100),
surname varchar(100),
address varchar(255),
phone varchar(50),
email varchar(50),
fk_sedeVoluntario int,
fk_personaVoluntario int not null unique,

constraint PK_voluntario primary key (idVoluntario,fk_personavoluntario)
);

alter table proyecto
add foreign key (fk_sedeProyecto) references sede(idSede);

alter table persona
add foreign key (fk_sedePersona) references sede(idSede);

alter table voluntario
add foreign key (fk_sedeVoluntario) references sede(idSede),
add foreign key (fk_personaVoluntario) references persona(personId);

