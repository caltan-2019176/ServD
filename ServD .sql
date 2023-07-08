/*
ServD
Fecha de creación: 05/07/2023
*/

drop database if exists DBServD;
create database DBServD;
use DBServD;


create table Proveedor(
	codigoProveedor int not null auto_increment,
    nombreProveedor varchar(100) not null,
    direccionProveedor varchar(100) not null,
    telefonoProveedor varchar(8) not null,
    primary key PK_codigoProveedor(codigoProveedor)
);
create table Equipo(
	codigoEquipo int not null auto_increment,
    nombreEquipo varchar(100) not null,
    descripcionEquipo varchar(100) not null,
    cantidad int not null,
    primary key PK_codigoEquipo(codigoEquipo)
);

Create table Proveedor_has_Equipo(
	codigoProveedor_has_Equipo int not null auto_increment, 
    descripcionProveedor varchar(100) not null, 
    codigoProveedor int not null, 
    codigoEquipo int not null, 
    primary key PK_codigoProveedor_has_Equipo(codigoProveedor_has_Equipo), 
    constraint FK_Proveedor_has_Equipo_Proveedor foreign key(codigoProveedor)
		references Proveedor(codigoProveedor), 
	constraint FK_Proveedor_has_Equipo_Equipo foreign key(codigoEquipo)
		references Equipo(codigoEquipo)
);

create table TipoServicio(
	codigoTipoServicio int not null auto_increment,
    tipoServicio varchar(50) not null,
    descripcion varchar(100) not null,
    precioTipoServicio decimal(10,2) not null,
    primary key PK_codigoTipo_servicio(codigoTipoServicio)
);
create table Servicio(
	codigoServicio int not null auto_increment,
    lugarServicio varchar(100) not null,
    numeroServicio varchar(8)not null,
    horaServicio time not null,
    fechaServicio Date not null,
    codigoTipoServicio int not null,
    primary key PK_codigoServicio(codigoServicio),
    constraint FK_Servicio_TipoServicio_ foreign key(codigoTipoServicio)
		references TipoServicio(codigoTipoServicio)
);

create table MedioTransporte(
	codigoTransporte int not null auto_increment,
    placa varchar(8) not null,
    tipoVehiculo varchar(100) not null,
    marca varchar(50) not null,
	primary key PK_codigoTransporte(codigoTransporte)
);
create table Empresa(
	codigoEmpresa int not null auto_increment,
    nombreEmpresa varchar(100) not null,
    telefonoEmpresa varchar(8) not null,
    direccionEmpresa varchar(100) not null,
    estadoEmpresa varchar(1) not null,
    primary key PK_codigoEmpresa(codigoEmpresa)
);
create table Compra(
	codigoCompra int not null auto_increment,
    costoCompra decimal(10,2) not null,
    descripcionCompra varchar(100) not null,
    fechaCompra date not null,
    codigoEmpresa int not null,
    primary key PK_codigoCompra(codigoCompra),
	constraint FK_Compra_Empresa foreign key(codigoEmpresa)
		references Empresa(codigoEmpresa)
);

Create table Servicio_has_Compra(
	Servicio_codigoCompra int not null auto_increment, 
	descripcionDetalle varchar(100) not null, 
    codigoServicio int not null, 
    codigoCompra int not null, 
    primary key PK_Servicio_codigoCompra(Servicio_codigoCompra), 
    constraint FK_Servicio_has_Compra_Servicio foreign key(codigoServicio)
		references Servicio(codigoServicio), 
	constraint FK_Servicio_has_Compra_Compra foreign key(codigoCompra)
		references Compra(codigoCompra)
);

create table TipoEmpleado(
	codigoTipoEmpleado int not null auto_increment,
    descripcionTipoEmpleado varchar(100) not null,
    categoria varchar(50) not null,
    sueldo decimal(10,2) not null,
    primary key PK_codigoTipoEmpleado(codigoTipoEmpleado)
);
create table Empleado(
	codigoEmpleado int not null auto_increment, 
	usuario varchar(15) not null,
    DPIEmpleado varchar(15) not null,
    nombresEmpleado varchar(100) not null,
    apellidosEmpleado varchar(100) not null,
    telefonoContacto varchar(8) not null,
    codigoTipoEmpleado int not null,
    codigoTransporte int not null, 
    codigoEquipo int not null,
    primary key PK_codigoEmpleado(codigoEmpleado),
    constraint FK_Empleado_TipoEmpleado foreign key(codigoTipoEmpleado)
		references tipoEmpleado(codigoTipoEmpleado),
	constraint FK_Empleado_Transporte foreign key(codigoTransporte)
		references medioTransporte(codigoTransporte),
	constraint FK_Empleado_Equipo foreign key(codigoEquipo)
		references equipo(codigoEquipo)
);

create table Empleados_has_Servicios(
	codigoEmpleados_has_servicios int not null auto_increment,
    costoServicio decimal(10,2) not null,
    codigoEmpleado int not null,
    codigoServicio int not null,
    primary key PK_codigoEmpleados_has_servicios(codigoEmpleados_has_servicios),
    constraint FK_empleado_has_servicio_Empleado foreign key(codigoEmpleado) 
		references Empleado(codigoEmpleado),
	constraint FK_servicio_has_servicio_Servicio foreign key(codigoServicio)
		references Servicio(codigoServicio)
    
);
create table Equipo_has_Empleado(
	Equipo_codigoEmpleado int not null auto_increment,
    codigoEquipo int not null,
    codigoEmpleado int not null,
    cantidadEquipo int not null,
    primary key PK_equipoEmpleado_Equipo(Equipo_codigoEmpleado),
	constraint FK_Equipo_has_Empleado_Equipo foreign key(codigoEquipo)
		references Equipo(codigoEquipo),
	constraint FK_Equipo_has_Empleado_Empleado foreign key(codigoEmpleado)
		references Empleado(codigoEmpleado)
);
show tables;