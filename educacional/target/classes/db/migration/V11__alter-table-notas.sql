alter table notas add matricula_id int;
alter table notas add disciplina_id int;

alter table  notas add constraint FK_notaMatriculas
foreign key (matricula_id) references matriculas(id);

alter table  notas add constraint FK_notaDisciplinas
foreign key (disciplina_id) references disciplinas(id);