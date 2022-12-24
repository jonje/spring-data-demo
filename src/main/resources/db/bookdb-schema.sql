drop database if exists bookdb;
drop user if exists `bookadmin`@`%`;
drop user if exists `bookuser`@`%`;
create database if not exists bookdb;
create user 'book-admin'@'%' IDENTIFIED BY 'password';
create user 'book-user'@'%' IDENTIFIED BY 'password';
grant select, insert, update, delete, create, drop, references, index, alter, execute, create view, show view,
    create routine, alter routine, event, trigger on `bookdb`.* to `'book-admin'@'%'`;
grant select, insert, update, delete, show view on `bookdb`.* to `'book-user'@'%'`;
flush privileges;

create table if not exists book (
    id bigint not null auto_increment,
    isbn varchar(13) not null,
    publisher varchar(100) not null,
    title varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table if not exists bookdb.hibernate_sequence
(
    next_val bigint null
) engine=InnoDB;

insert into hibernate_sequence values ( 1 )
