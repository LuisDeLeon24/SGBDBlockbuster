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

<<<<<<< HEAD
-- Insertar datos en la tabla Membresias
INSERT INTO Membresias (tipo, costo, beneficios) VALUES 
('Básica', 19.99, 'Acceso a contenido limitado'),
('Estándar', 39.99, 'Acceso a todo el contenido'),
('Premium', 59.99, 'Acceso a todo el contenido y beneficios adicionales'),
('Estudiante', 9.99, 'Acceso a contenido limitado con descuento'),
('Familiar', 79.99, 'Acceso a todo el contenido para toda la familia');

-- Insertar datos en la tabla Tiendas
INSERT INTO Tiendas (direccion, ciudad, tematica) VALUES 
('123 Calle Principal', 'Ciudad A', 'Ciencia Ficción'),
('456 Avenida Secundaria', 'Ciudad B', 'Drama'),
('789 Calle Tercera', 'Ciudad C', 'Comedia'),
('101 Calle Cuarta', 'Ciudad D', 'Terror'),
('202 Calle Quinta', 'Ciudad E', 'Acción');

-- Insertar datos en la tabla Empleados
INSERT INTO Empleados (nombreEmpleado, puesto, salario, tiendaId) VALUES 
('Juan Pérez', 'Gerente', 3000.00, 1),
('María López', 'Cajero', 1500.00, 2),
('Pedro Martínez', 'Vendedor', 1800.00, 3),
('Ana Gómez', 'Asistente', 1200.00, 4),
('Carlos Rodríguez', 'Supervisor', 2500.00, 5);

-- Insertar datos en la tabla Clientes
INSERT INTO Clientes (nombreCliente, telefono, generoFavorito, membresiaId) VALUES 
('Luis García', '123456789', 'Ciencia Ficción', 1),
('Elena Fernández', '987654321', 'Drama', 2),
('Jorge Sánchez', '456789123', 'Comedia', 3),
('Marta Díaz', '789123456', 'Terror', 4),
('Roberto Torres', '321654987', 'Acción', 5);

-- Insertar datos en la tabla Peliculas
INSERT INTO Peliculas (titulo, genero, estreno, director) VALUES 
('La Guerra de las Galaxias', 'Ciencia Ficción', '1977-05-25', 'George Lucas'),
('El Padrino', 'Drama', '1972-03-24', 'Francis Ford Coppola'),
('Superbad', 'Comedia', '2007-08-17', 'Greg Mottola'),
('El Exorcista', 'Terror', '1973-12-26', 'William Friedkin'),
('Duro de Matar', 'Acción', '1988-07-20', 'John McTiernan');

-- Insertar datos en la tabla Transacciones
INSERT INTO Transacciones (clienteId, membresiaId, empleadoId, tiendaId, peliculaId) VALUES 
(1, 1, 1, 1, 1),
(2, 2, 2, 2, 2),
(3, 3, 3, 3, 3),
(4, 4, 4, 4, 4),
(5, 5, 5, 5, 5);

-- Insertar datos en la tabla DetallePeliculas
INSERT INTO DetallePeliculas (transaccionId, peliculaId) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);



