CREATE DATABASE IF NOT EXISTS `films` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `films`;


CREATE TABLE IF NOT EXISTS `profile` (
  `profile_id` int(11) NOT NULL,
  `name` VARCHAR(500) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tabla de perfiles';

CREATE TABLE IF NOT EXISTS `gender` (
  `gender_id` int(11) NOT NULL,
  `name` VARCHAR(500) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`gender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tabla de generos de peliculas';

CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) COLLATE utf8_bin NOT NULL,
  `description` longtext,
  `image` VARCHAR(500) NOT NULL,
  `create_at` datetime NOT NULL,
  `release_date` date,
  `actors` VARCHAR(500) COLLATE utf8_bin,
  `gender_id` int(11) NOT NULL,
  `rating` int(11),
  PRIMARY KEY (`movie_id`),
  FOREIGN KEY (`gender_id`) REFERENCES gender(`gender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tabla de peliculas';


CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) COLLATE utf8_bin NOT NULL,
  `email` VARCHAR(100) not null,
  `password` VARCHAR(100) NOT NULL,
  `create_at` datetime NOT NULL,
  `profile_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`profile_id`) REFERENCES profile(`profile_id`),
  UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tabla de usuarios';

insert into gender(gender_id, name) VALUES (1, 'Acción');
insert into gender(gender_id, name) values (2, 'Aventura');
insert into gender(gender_id, name) values (3, 'Comedia');
insert into gender(gender_id, name) values (4, 'Terror');
insert into gender(gender_id, name) values (5, 'Animado');
insert into gender(gender_id, name) values (6, 'Suspenso');

-- profile
insert into profile(profile_id, name) VALUES (1, 'Adminis1trador');
insert into profile(profile_id, name) VALUES (2, 'Cliente2');

-- user
insert into user (user_id, name, email, create_at, password, profile_id)
  values (1, 'Julio Martínez', 'julio.martinez@iudigital.edu.co', now(), '555555', 1);

insert into user (user_id, name, email, create_at, password, profile_id)
  values (2, 'Adriana Aguilar', 'adriana.a@iudigital.edu.co', now(), '123456', 2);
  
SELECT * FROM user;
SELECT * FROM profile;
SELECT * FROM gender;
iu_wc_2iu_wc_2iu_wc_2filmsfilms