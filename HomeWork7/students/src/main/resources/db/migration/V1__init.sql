create table students
(
    id   bigserial primary key,
    name varchar(255),
    age  int
);

insert into students(name, age)

values ('Вася', '15'),
       ('Игорь', '24'),
       ('Анатолий', '17');