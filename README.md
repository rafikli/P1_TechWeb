# P1_TechWeb
TecWeb

# Guia Database Projeto 1- TecWeb 2019.2 #


CREATE DATABASE Projeto1;

USE Projeto1;

CREATE TABLE Alunos (
 id INT NOT NULL AUTO_INCREMENT,
 nome VARCHAR(32) NOT NULL,
 duvida VARCHAR(32) NOT NULL,
 PRIMARY KEY (ID)
);

INSERT INTO Alunos (nome, duvida) VALUES ('Gepeto','duvida cruel');
