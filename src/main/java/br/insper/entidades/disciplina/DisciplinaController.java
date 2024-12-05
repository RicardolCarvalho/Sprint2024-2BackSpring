package br.insper.entidades.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarDisciplinaDTO cadastrarDisciplina(@RequestBody CadastrarDisciplinaDTO dto) {
        return disciplinaService.cadastrarDisciplina(dto);
    }

    @GetMapping
    public List<RetornarDisciplinaDTO> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @GetMapping("/{id}")
    public RetornarDisciplinaDTO buscarDisciplina(@PathVariable String id) {
        return disciplinaService.buscarDisciplina(id);
    }

    @PutMapping("/{id}")
    public RetornarDisciplinaDTO atualizarDisciplina(@PathVariable String id, @RequestBody CadastrarDisciplinaDTO dto) {
        return disciplinaService.atualizarDisciplina(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirDisciplina(@PathVariable String id) {
        disciplinaService.excluirDisciplina(id);
    }
}
