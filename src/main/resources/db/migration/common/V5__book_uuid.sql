create table if not exists book_uuid (
    id binary(16) not null,
    isbn varchar(13) not null,
    publisher varchar(255) not null,
    title varchar(255) not null,
    primary key (id)
) engine = InnoDB;