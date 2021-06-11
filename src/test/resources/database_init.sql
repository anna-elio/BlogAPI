CREATE TABLE IF NOT EXISTS users (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)
);
--
--
-- ddinuzzo/password02
INSERT INTO users
(username, password)
VALUES('ddinuzzo', '$2a$10$vj3PqvSqQSsLhknZpxU2oOIUOdmm6cpPu1shwcyXHVzba.xBWLe4K');


--
-- dump db
--
drop database blog;

create database blog;

use blog;

CREATE TABLE IF NOT EXISTS users (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categorie(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	categoria varchar(20) not null,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS articoli (
	id bigint unsigned not null auto_increment,
	titolo varchar(50) not null,
	sottotitolo varchar(50),
	testo text not null,
	categoria bigint unsigned  not null,
	autore bigint unsigned  not null,
	stato varchar(10) check ( stato IN ('bozza', 'pubblicato')),
	data_pubb datetime,
	data_modifica datetime ON UPDATE CURRENT_TIMESTAMP,
	data_creazione datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	FOREIGN KEY (autore) references users(id) on delete cascade,
	FOREIGN KEY (categoria) references categorie(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tags(
	id bigint unsigned NOT NULL AUTO_INCREMENT,
	tag varchar(10) not null,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tags_articoli(
	id_articolo bigint unsigned not null,
	id_tag bigint unsigned not null,
	FOREIGN KEY (id_tag) references tags(id) on update cascade,
	FOREIGN KEY (id_articolo) references articoli(id) on update cascade
);