DROP table if exists tasks;
DROP table if exists projects;

CREATE TABLE projects (
	id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    PRIMARY KEY(id)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE tasks (
	id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    description varchar(255) DEFAULT NULL,
    project int(11) NOT NULL,
    PRIMARY KEY(id),
	FOREIGN KEY (project)
        REFERENCES projects(id)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO todo.projects (name) VALUES ("Privat");
INSERT INTO todo.projects (name) VALUES ("Uni");
INSERT INTO todo.projects (name) VALUES ("Arbeit");

INSERT INTO todo.tasks (name, description, project) VALUES ("Einkaufen", "Brot, Milch, Käse, Salat, Schokolade", 1);
INSERT INTO todo.tasks (name, description, project) VALUES ("1657 EA1", "Bis 15.10.2015 fertig", 2);
INSERT INTO todo.tasks (name, description, project) VALUES ("Java EE", "Herausfinden welche Technologien ich lernen muss", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("Hibernate", "Tutorial finden", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("1896 KE1", "Durchlesen und Zusammenfassung", 2);
INSERT INTO todo.tasks (name, description, project) VALUES ("Regal", "Regal aussuchen und einkaufen", 1);
INSERT INTO todo.tasks (name, description, project) VALUES ("JPA", "Herausfinden wie n:m Beziehungen funktionieren", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("Linux", "Bash-Scripting weiter lernen", 1);
