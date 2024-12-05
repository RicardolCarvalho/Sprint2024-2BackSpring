package br.insper.entidades.turma;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarTurmaDTO cadastrarTurma(@Valid @RequestBody CadastraTurmaDTO turmaDTO){
        return turmaService.cadastraTurma(turmaDTO);
    }
    @GetMapping
    public List<Turma> listarTurma(@RequestParam(required = false) String anoTurma,
                                   String nomeTurma){
        return turmaService.listarTurmas(anoTurma, nomeTurma);
    }

    @PutMapping("/{id}")
    public RetornarTurmaEdicaoDTO editarTurma(@PathVariable String id,
                                              @RequestBody EditarTurmaDTO editarTurmaDTO){
        return turmaService.editarTurma(id, editarTurmaDTO);
    }
}
