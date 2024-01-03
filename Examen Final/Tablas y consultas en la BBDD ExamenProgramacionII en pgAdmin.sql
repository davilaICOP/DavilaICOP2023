/*Creación de la tabla Sufragante*/

CREATE TABLE Sufragante (
    id_sufragante SERIAL PRIMARY KEY,
    apellido VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    genero VARCHAR(50) NOT NULL,
    domicilio VARCHAR(255) NOT NULL,
    du INT UNIQUE NOT NULL,
    emitio_voto BOOLEAN DEFAULT FALSE
);

/*Ver el padrón de votantes ordenado*/

SELECT apellido, nombre, edad FROM Sufragante ORDER BY apellido, nombre, edad;
SELECT * FROM Sufragante ORDER BY apellido, nombre, edad;

/*Creación de la tabla Candidato*/

CREATE TABLE Candidato (
    id_candidato SERIAL PRIMARY KEY,
    apellido VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    genero VARCHAR(50) NOT NULL,
    domicilio VARCHAR(255) NOT NULL,
    du INT UNIQUE NOT NULL,
    partido_politico VARCHAR(255) NOT NULL,
    lema VARCHAR(255) NOT NULL,
    cantidad_votos INT DEFAULT 0
);

/*Ver la lista de candidatos ordenada*/

SELECT partido_politico, apellido, nombre FROM Candidato ORDER BY partido_politico, apellido, nombre;
SELECT * FROM Candidato ORDER BY partido_politico, apellido, nombre;

/*Creación de la tabla Votos_Especiales*/

CREATE TABLE Votos_Especiales (
    tipo VARCHAR(50) UNIQUE,
    cantidad INT DEFAULT 0
);

/*Insertar los tipos de votos especiales*/

INSERT INTO Votos_Especiales (tipo, cantidad) VALUES ('Blanco', 0);
INSERT INTO Votos_Especiales (tipo, cantidad) VALUES ('Impugnado', 0);

/*Ver la cantidad de votos en blancos y votos impugnados*/

SELECT * FROM Votos_Especiales;

/*Ver el escrutinio provisorio*/

SELECT partido_politico || ': ' || apellido || ' ' || nombre AS tipo_voto, cantidad_votos FROM Candidato UNION ALL
SELECT tipo AS tipo_voto, cantidad AS cantidad_votos FROM Votos_Especiales WHERE tipo = 'Blanco' UNION ALL
SELECT tipo AS tipo_voto, cantidad AS cantidad_votos FROM Votos_Especiales WHERE tipo = 'Impugnado';

/*Crear la tabla Validar_Escrutinio*/

CREATE TABLE Validar_Escrutinio (
    descripcion VARCHAR(50) UNIQUE,
    cantidad INT DEFAULT 0
);

/*Insertar los datos para validar el escrutinio*/

INSERT INTO Validar_Escrutinio (descripcion, cantidad) VALUES ('Sufragantes que votaron', 0);
INSERT INTO Validar_Escrutinio (descripcion, cantidad) VALUES ('Votos escrutados', 0);

/*Ver la validación del escrutinio*/

SELECT * FROM Validar_Escrutinio;

/*Ver la terna de ganadores*/

SELECT nombre, apellido, cantidad_votos FROM Candidato ORDER BY cantidad_votos DESC LIMIT 3;

/*Ver los votos totales por partido:*/

SELECT partido_politico, SUM(cantidad_votos) AS cantidad_votos FROM Candidato GROUP BY partido_politico;