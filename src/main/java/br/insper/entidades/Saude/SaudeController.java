package br.insper.entidades.Saude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/saude")
public class SaudeController {
    @Autowired
    private SaudeService saudeService;
    private SaudeRepository saudeRepository;

    @PostMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> salvarSaude(@PathVariable String alunoId, @RequestBody Saude saude) {
        try {
            saudeService.salvarOuAtualizarSaude(alunoId, saude);
            return ResponseEntity.ok("Saude salva com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar Saude: " + e.getMessage());
        }
    }

    @PutMapping("/{alunoId}")
    public ResponseEntity<String> salvarOuAtualizarSaude(@PathVariable String alunoId, @RequestBody Saude saude) {
        try {
            saudeService.salvarOuAtualizarSaude(alunoId, saude);
            return ResponseEntity.ok("Saúde salva ou atualizada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar ou atualizar Saúde: " + e.getMessage());
        }
    }


    @DeleteMapping("/{alunoId}")
    public ResponseEntity<String> deletarSaude(@PathVariable String alunoId) {
        try {
            saudeService.deletarSaude(alunoId);
            return ResponseEntity.ok("Saude deletada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<?> getSaude(@PathVariable String alunoId) {
        try {
            Saude saude = saudeService.getSaude(alunoId);
            return ResponseEntity.ok(saude);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        }
    }
}