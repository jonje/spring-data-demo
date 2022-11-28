create database test;
use test;

create table if not exists post (

    id int auto_increment not null,
    title text not null,
    content mediumtext not null,
    primary key (id)
);

create table if not exists comments (
    id int auto_increment not null,
    content text not null,
    comment_month int not null,
    comment_year int not null,
    post_id int not null,
    constraint `fk_post`
        foreign key (post_id) references post (id)
        on delete cascade,
    primary key (id)
);

create table if not exists book (
    id int auto_increment not null,
    title varchar()
)

insert into post (title, content) values ('Test Post', 'This is a test post for the app.');
insert into post (title, content) values ('Test Post 2', 'This is a test post for the app. This one has a little more details');
insert into comments (content, comment_month, comment_year, post_id) values ('First comment', 10, 2022, 1);
insert into comments (content, comment_month, comment_year, post_id) values ('Comment on a new month', 11, 2022, 1);
insert into comments (content, comment_month, comment_year, post_id) values ('Comment on another post', 10, 2022, 1);


