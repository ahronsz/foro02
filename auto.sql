create database auto CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use auto;
create table auto (id int primary key auto_increment, marca varchar(100), modelo varchar(100), color varchar(100), costo double, fecha_fabricacion datetime not null);


