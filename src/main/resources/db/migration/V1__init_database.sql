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