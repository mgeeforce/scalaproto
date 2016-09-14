# --- !Ups

CREATE TABLE courses (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR,
    address VARCHAR,
    city VARCHAR
);

CREATE TABLE tee_sheets (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    course_id INTEGER,
	date DATETIME,
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

# --- !Downs

DROP TABLE IF EXISTS tee_sheets;
DROP TABLE IF EXISTS course;