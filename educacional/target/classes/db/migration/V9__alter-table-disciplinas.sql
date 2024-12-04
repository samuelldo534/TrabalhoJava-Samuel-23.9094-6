alter table disciplinas add curso_id int;
alter table disciplinas add professor_id int;

alter table  disciplinas add constraint FK_cursoDisciplina
foreign key (curso_id) references cursos(id);

alter table disciplinas add constraint FK_professorDisciplina
foreign key (professor_id) references professores(id);