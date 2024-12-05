package br.insper.entidades.aluno;

import br.insper.entidades.turma.Turma;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable String id) {
        Aluno aluno = alunoService.getAlunoById(id);
        return ResponseEntity.ok(aluno);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornaAlunoDTO cadastraAluno(@Valid @RequestBody CadastraAlunoDTO alunoDTO){
        return alunoService.cadastraAluno(alunoDTO);
    }

    @GetMapping
    public List<Aluno> listarAlunos(@RequestParam(required = false) String nomeTurma,
                                    @RequestParam(required = false) String nomeAluno){
        return alunoService.listarAlunos(nomeTurma, nomeAluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAluno(@PathVariable String id){
        alunoService.excluirAluno(id);
    }

    @PutMapping("/{id}")
    public RetornaAlunoDTO editarAluno(@PathVariable String id,
                                       @RequestBody EditarAlunoDTO editarAlunoDTO){
        return alunoService.editarAluno(id, editarAlunoDTO);
    }
}
