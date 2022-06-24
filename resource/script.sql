create database contactslist
create table contact(
id int not null auto_increment primary key,
nome varchar,
idade int,
email varchar,
dataCadastro date
)