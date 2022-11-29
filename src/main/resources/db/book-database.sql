drop database if exists bookdb;
drop user if exists `bookadmin`@`%`;
drop user if exists `bookuser`@`%`;
create database if not exists bookdb;
create user if not exists `bookadmin`@`%` identified with mysql_native_password by 'Winter2022;';