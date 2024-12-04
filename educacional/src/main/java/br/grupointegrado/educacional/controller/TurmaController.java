package br.grupointegrado.educacional.controller;


import br.grupointegrado.educacional.dto.AlunoRequestDTO;
import br.grupointegrado.educacional.dto.TurmaRequestDTO;
import br.grupointegrado.educacional.model.Aluno;
import br.grupointegrado.educacional.model.Turma;
import br.grupointegrado.educacional.repository.AlunoRepository;
import br.grupointegrado.educacional.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turma>  findById(@PathVariable Integer id){
        Turma turma= this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        return ResponseEntity.ok(turma);
    }
    @PostMapping
    public Turma save(@RequestBody TurmaRequestDTO dto){
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        return this.repository.save(turma);
    }
    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id,
                        @RequestBody TurmaRequestDTO dto){
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        return this.repository.save(turma);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        this.repository.delete(turma);
        return ResponseEntity.noContent().build();

    }


}
