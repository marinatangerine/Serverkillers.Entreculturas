create database ong;

create table sede (
idSede int not null auto_increment,
ciudad varchar(100),
direccion varchar(255),
telefono varchar(50),
email varchar (50),
central bool,

primary key (idSede)
);

-- drop table proyecto;
create table proyecto (
codProyecto int not null auto_increment,
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
personId int not null auto_increment,
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
personId int primary key,
areaActividades varchar(255)
);

alter table proyecto
add foreign key (fk_sedeProyecto) references sede(idSede);

alter table persona
add foreign key (fk_sedePersona) references sede(idSede);

alter table voluntario
add foreign key (personId) references persona(personId);

-- stored procedures
delimiter //
create procedure insertPersona(in pUserName varchar(50), in pPass varchar(10), in pAdministrator bool, in pNamePersona varchar(100), in pSurname varchar(100), in pAddress varchar(255), in pPhone varchar(50), in pEmail varchar (50), in pIdSede int, out id int)
begin
	insert into 
		persona (userName, pass, administrator, namePersona, surname, address, phone, email, fk_sedePersona)
        values
        (pUserName, pPass, pAdministrator, pNamePersona, pSurname, pAddress, pPhone, pEmail, pIdSede);
	set id = last_insert_id();
end //

delimiter //
create procedure insertVoluntario(in vAreaActividades varchar(255), in vPersonId int, out id int)
begin
	insert into
		voluntario (areaActividades, personId)
        values
        (vAreaActividades, vPersonId);
	set id = last_insert_id();
end //

delimiter //
create procedure insertSede(in sCiudad varchar(100), in sDireccion varchar(255), in sTelefono varchar(50), in sEmail varchar(50), out id int)
begin
	insert into
		sede (ciudad, direccion, telefono, email)
		values (SCiudad, SDireccion, STelefono, sEmail);
	set id = last_insert_id();
end //

delimiter //
create procedure insertProyecto(in pNombre varchar(100), in pLineaAccion varchar(255), in pSubLinea varchar(255), in pPais varchar(50), in pLocalizacion varchar(100), in pFechaInicio date, in pFechaFin date, in pAcciones varchar(255), in pIdSede int, out id int)
begin
	insert into 
		proyecto (nombre, lineaAccion, subLinea, pais, localizacion, fechaInicio, fechaFin, acciones, fk_sedeProyecto)
        values (pNombre, pLineaAccion, pSubLinea, pPais, pLocalizacion, pFechaInicio, pFechaFin, pAcciones, pIdSede);
	set id = last_insert_id();
end //