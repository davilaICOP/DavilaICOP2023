/*Creación de la tabla Ciudadano*/

CREATE TABLE Ciudadano (
    id_ciudadano SERIAL PRIMARY KEY,
    apellido VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    genero VARCHAR(50) NOT NULL,
    domicilio VARCHAR(255) NOT NULL,
    du INT UNIQUE NOT NULL
);

/*Ver todos los ciudadanos*/

SELECT * FROM Ciudadano;

/*Creación de la tabla Sufragante*/

CREATE TABLE Sufragante (
    emitio_voto BOOLEAN DEFAULT FALSE
) INHERITS (Ciudadano);

/*Ver el padrón de votantes ordenado*/

SELECT apellido, nombre, edad FROM Sufragante ORDER BY apellido, nombre, edad;
SELECT * FROM Sufragante ORDER BY apellido, nombre, edad;

/*Creación de la tabla Candidato*/

CREATE TABLE Candidato (
    partido_politico VARCHAR(255) NOT NULL,
    lema VARCHAR(255) NOT NULL,
    cantidad_votos INT DEFAULT 0
) INHERITS (Ciudadano);

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

/*Ver la validación del escrutinio*/

SELECT 'Sufragantes que votaron' AS descripcion,
COUNT(*) AS cantidad FROM Sufragante WHERE emitio_voto = TRUE UNION
SELECT 'Votos escrutados' AS descripcion, 
(SELECT SUM(cantidad_votos) FROM Candidato) +
(SELECT cantidad FROM Votos_Especiales WHERE tipo = 'Blanco') +
(SELECT cantidad FROM Votos_Especiales WHERE tipo = 'Impugnado') AS cantidad;

/*Ver la terna de ganadores*/

SELECT nombre, apellido, cantidad_votos FROM Candidato ORDER BY cantidad_votos DESC LIMIT 3;

/*Ver los votos totales por partido:*/

SELECT partido_politico, SUM(cantidad_votos) AS cantidad_votos FROM Candidato GROUP BY partido_politico;