create table if not exists author_composite (
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    country varchar(255) not null,
    primary key (first_name, last_name)
) engine = InnoDB;