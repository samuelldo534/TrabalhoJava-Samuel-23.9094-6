alter table matriculas add aluno_id int;
alter table matriculas add turma_id int;

alter table  matriculas add constraint FK_alunoMatriculas
foreign key (aluno_id) references alunos(id);

alter table  matriculas add constraint FK_tumaMatriculas
foreign key (turma_id) references turmas(id);