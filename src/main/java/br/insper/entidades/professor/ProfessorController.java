package br.insper.entidades.professor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarProfessorDTO cadastraProfessor(@Valid @RequestBody CadastraProfessorDTO professorDTO) {
        return professorService.cadastraProfessor(professorDTO);
    }

    @GetMapping
    public Page<Professor> listarProfessores(@RequestParam(required = false) String nome,
                                             @RequestParam(required = false) Boolean ativo,
                                             Pageable pageable) {
        return professorService.listarProfessores(nome, ativo, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProfessor(@PathVariable String id) {
        professorService.excluirProfessor(id);
    }

    @PutMapping("/{id}")
    public RetornarProfessorDTO atualizarProfessor(@PathVariable String id,
                                                   @Valid @RequestBody CadastraProfessorDTO professorDTO) {
        return professorService.atualizarProfessor(id, professorDTO);
    }
}
