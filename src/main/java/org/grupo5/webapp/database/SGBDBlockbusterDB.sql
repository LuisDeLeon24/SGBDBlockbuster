create 
database SGBDBlockbuster;

use SGBDBlockbuster;

create table Membresias(
	membresiaId int not null auto_increment,
    tipo varchar(100) not null,
    costo decimal(10,2) not null,
    beneficios varchar(100)not null,
    primary key PK_membresiaId(membresiaId)
);

create table Tiendas(
	tiendaId int not null auto_increment,
    direccion varchar(100) not null,
    ciudad varchar(100)not null,
    tematica varchar(100)not null,
    primary key PK_tiendaId(tiendaId)
);

create table Empleados(
	empleadoId int not null auto_increment,
    nombreEmpleado varchar(100),
    puesto varchar(100),
    salario decimal(10,2),
    tiendaId int,
    primary key PK_empleadoId(empleadoId),
    constraint FK_Empleados_Tiendas foreign key(tiendaId)
		references Tiendas(tiendaId)
);


create table Clientes(
	clienteId int not null auto_increment,
    nombreCliente varchar(100) not null,
    telefono varchar(100) not null,
    generoFavorito varchar(100)not null,
    membresiaId int,
    primary key PK_clienteId(clienteId),
    constraint FK_Clientes_Membresias foreign key(membresiaId)
		references Membresias(membresiaId)
);



create table Peliculas(
	peliculaId int not null auto_increment,
    titulo varchar(100) not null,
    genero varchar(100) not null,
    estreno date not null,
    director varchar(100),
    primary key PK_peliculaId(peliculaId)
);

create table Transacciones(
	transaccionId int not null auto_increment,
    clienteId int not null,
    membresiaId int not null,
    empleadoId int not null,
    tiendaId int not null,
    peliculaId int not null,
    primary key PK_transaccionId(transaccionId),
    constraint FK_Transacciones_Clientes foreign key(clienteId)
		references Clientes(clienteId),
	constraint FK_Transacciones_membresias foreign key(membresiaId)
		references Membresias(membresiaId),
	constraint FK_Transacciones_Empleados foreign key(empleadoId)
		references Empleados(empleadoId),
	constraint FK_Transacciones_Tiendas foreign key(tiendaId)
		references Tiendas(tiendaId),
	constraint FK_Transacciones_Peliculas foreign key(peliculaId)
		references Peliculas(peliculaId)
);

create table DetallePeliculas(
	detallePeliculaId int not null auto_increment,
    transaccionId int not null,
    peliculaId int not null,
    primary key PK_detallePeliculaId(detallePeliculaId),
    constraint FK_detallePeliculas_Transacciones foreign key(transaccionId)
		references Transacciones(transaccionId),
	constraint FK_detallePeliculas_peliculas foreign key(peliculaId)
		references Peliculas(peliculaId)
);





