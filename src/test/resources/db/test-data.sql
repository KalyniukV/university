insert into lector(first_name, last_name, lector_degree, salary) values ('Tkachuk', 'Vitaliy', 'PROFESSOR', 3000);
insert into lector(first_name, last_name, lector_degree, salary) values ('Oliynyk', 'Olga', 'ASSOCIATE_PROFESSOR', 2000);
insert into lector(first_name, last_name, lector_degree, salary) values ('Bodnarchuk', 'Tetiana', 'ASSOCIATE_PROFESSOR', 2000);
insert into lector(first_name, last_name, lector_degree, salary) values ('Rarok', 'Lilia', 'ASSISTANT', 1000);
insert into lector(first_name, last_name, lector_degree, salary) values ('Opria', 'Bogdana', 'ASSISTANT', 1000);

insert into department(department_name, head_of_department) values ('Economics', 1);

insert into department_lector(department_id, lector_id) values (1, 1);
insert into department_lector(department_id, lector_id) values (1, 2);
insert into department_lector(department_id, lector_id) values (1, 3);
insert into department_lector(department_id, lector_id) values (1, 4);
insert into department_lector(department_id, lector_id) values (1, 5);
