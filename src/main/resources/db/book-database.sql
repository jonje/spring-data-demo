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

