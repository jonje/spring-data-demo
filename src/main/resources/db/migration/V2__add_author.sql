create table if not exists author (
    id bigint not null auto_increment,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    primary key (id)
) engine=InnoDB;
