/**
* Projeto de um sistema para gestão de estoque
* @author Guilherme Morgado
* @version 1.0
*/

create database dbestoque;
use dbestoque;

create table usuario (
id int primary key auto_increment,
usuario varchar(50) not null, 
login varchar(20) not null, 
senha varchar(250) not null
);

describe usuario;
-- CREATE (inserir 5 usuarios)
insert into usuario (usuario, login, senha)
values ('Guilherme Morgado', 'Guizinho', '123@senac');
insert into usuario (usuario, login, senha)
values ('Neymar Jr', 'Neyzinho', '123@senac');
insert into usuario (usuario, login, senha)
values ('Kaka', 'Kakazinho', '123@senac');
insert into usuario (iusuario, login, senha)
values ('Endrick', 'Endrickzinhu', '123@senac');
insert into usuario (usuario, login, senha)
values ('Ronaldo', 'Ronaldozinhu', '123@senac');


/*********** CRUD ************/

-- READ1 (selecionar todos os usuarios)
-- a linha abaixo seleciona todos os registros da tabela
select * from usuario;
-- READ2 (selecionar um usuarios especifico por id)
select * from usuarios where id = 1;
-- UPDATE (alterar todos os dados de um usuario especifico)
update usuarios set usuario = 'Guilherme Morgado' where id = 1;
-- Delete (excluir um usuario especifico)
delete from usuarios where id = 2;
-- Gerar a documentação - Modelo ER (engenharia reversa)