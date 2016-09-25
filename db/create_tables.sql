-- Delete all tables from database, if the exist
DROP table if exists tasks;
DROP table if exists projects;

-- Create projects table
CREATE TABLE projects (
	id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    PRIMARY KEY(id),
    version int(11) NOT NULL DEFAULT 0
)   ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create tasks table
CREATE TABLE tasks (
	id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    description varchar(255) DEFAULT NULL,
    project int(11) NOT NULL,
	version int(11) NOT NULL DEFAULT 0,
    PRIMARY KEY(id),
	FOREIGN KEY (project)
        REFERENCES projects(id)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Add some records to projects table
INSERT INTO todo.projects (name) VALUES ("Projekt 1");
INSERT INTO todo.projects (name) VALUES ("Projekt 2");
INSERT INTO todo.projects (name) VALUES ("Projekt 3");

-- Add some records to tasks table
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 1", "Beschreibung von Task 1", 1);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 2", "Beschreibung von Task 2", 2);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 3", "Beschreibung von Task 3", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 4", "Beschreibung von Task 4", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 5", "Beschreibung von Task 5", 2);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 6", "Beschreibung von Task 6", 1);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 7", "Beschreibung von Task 7", 3);
INSERT INTO todo.tasks (name, description, project) VALUES ("Task 8", "Beschreibung von Task 8", 1);
