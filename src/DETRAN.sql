create database DETRAN;
create table VEICULO
(Placa char(7) not null primary key, DTemplacamento char(8), Marca varchar(25) not null,
 Modelo varchar(35), Ano decimal(4), Cor varchar(15), Proprietario decimal(11) not null);
create table TRANSFERENCIA
(Placa char(7) not null, DTtransferencia char(8) not null, Comprador decimal(11) not null,
 Vendedor decimal(11) not null, constraint primary key (Placa,DTtransferencia));

