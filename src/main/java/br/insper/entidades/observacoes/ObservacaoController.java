package br.insper.entidades.observacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/observacoes")
public class ObservacaoController {

    @Autowired
    private ObservacaoService observacaoService;

    @PostMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> salvarObservacao(@PathVariable String alunoId, @RequestBody Observacao observacao) {
        try {
            observacaoService.salvarObservacao(alunoId, observacao);
            return ResponseEntity.ok("Observação salva com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar observação: " + e.getMessage());
        }
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<?> getObservacao(@PathVariable String alunoId) {
        try {
            Observacao observacao = observacaoService.buscarObservacao(alunoId);
            return ResponseEntity.ok(observacao);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        }
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<String> atualizarObservacao(@PathVariable String alunoId, @RequestBody Observacao observacao) {
        try {
            observacaoService.atualizarObservacao(alunoId, observacao);
            return ResponseEntity.ok("Observação atualizada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar a observação: " + e.getMessage());
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deletarObservacao(@PathVariable String id) {
        try {
            observacaoService.deletarObservacao(id);
            return ResponseEntity.ok("Observação deletada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        }
    }
}