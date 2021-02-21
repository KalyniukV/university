CREATE TABLE LECTOR (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    lector_degree VARCHAR(50),
    salary DECIMAL,

    CONSTRAINT pk_lector_id PRIMARY KEY (id)
);

CREATE TABLE DEPARTMENT (
    id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR (60) NOT NULL,
    head_of_department INT NOT NULL,

    CONSTRAINT pk_department_id PRIMARY KEY (id),
    CONSTRAINT fk_head_of_department FOREIGN KEY (head_of_department) REFERENCES lector (id)
);

CREATE TABLE DEPARTMENT_LECTOR (
    department_id INT NOT NULL,
    lector_id INT NOT NULL,

    CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department (id),
    CONSTRAINT fk_lector_id FOREIGN KEY (lector_id) REFERENCES lector (id)
);