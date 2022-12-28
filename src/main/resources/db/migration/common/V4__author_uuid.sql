create table author_uuid (
    id varchar(36) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    primary key (id)
) engine = InnoDb;