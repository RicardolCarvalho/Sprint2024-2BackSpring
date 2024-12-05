package br.insper.entidades.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> getPortfolioByNome(@RequestParam String nome) {
        List<Portfolio> portfolios = portfolioService.findByNome(nome);
        return ResponseEntity.ok(portfolios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable String id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio);
    }

    @PostMapping("/{id}/laudos")
    public ResponseEntity<Portfolio> adicionarLaudos(@PathVariable String id, @RequestBody List<String> laudos) {
        Portfolio portfolio = portfolioService.adicionarLaudos(id, laudos);
        return ResponseEntity.ok(portfolio);
    }

    @GetMapping("/{id}/laudos")
    public ResponseEntity<List<String>> getLaudos(@PathVariable String id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio.getLaudos());
    }

    @PostMapping("/{id}/observacoes")
    public ResponseEntity<Portfolio> adicionarObservacoes(@PathVariable String id, @RequestBody List<String> observacoes) {
        Portfolio portfolio = portfolioService.adicionarObservacoes(id, observacoes);
        return ResponseEntity.ok(portfolio);
    }

    @GetMapping("/{id}/observacoes")
    public ResponseEntity<List<String>> getObservacoes(@PathVariable String id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio.getObservacoes());
    }

    @DeleteMapping("/{id}/observacoes")
    public ResponseEntity<Portfolio> removerObservacao(@PathVariable String id, @RequestBody String observacao) {
        Portfolio portfolio = portfolioService.removerObservacao(id, observacao);
        return ResponseEntity.ok(portfolio);
    }


    @PostMapping("/{id}/perguntas")
    public ResponseEntity<Portfolio> adicionarPerguntas(@PathVariable String id, @RequestBody Map<String, String> novasPerguntas) {
        Portfolio portfolio = portfolioService.adicionarPerguntas(id, novasPerguntas);
        return ResponseEntity.ok(portfolio);
    }

    @GetMapping("/{id}/perguntas")
    public ResponseEntity<Map<String, String>> getPerguntas(@PathVariable String id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        return ResponseEntity.ok(portfolio.getPerguntas());
    }

    @GetMapping("/{id}/notas-frequencias")
    public ResponseEntity<Map<String, Map<String, Object>>> getNotasEFrequencias(@PathVariable String id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        Map<String, Map<String, Object>> response = new HashMap<>();

        if (portfolio.getDadosAluno() != null) {
            portfolio.getDadosAluno().forEach((nome, materias) -> {
                for (Portfolio.Materia materia : materias) {
                    response.put(materia.getMateria(), materia.getNotas());
                }
            });
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar-nome-aluno")
    public ResponseEntity<Void> atualizarNomeAluno(@RequestBody Map<String, String> nomes) {
        String nomeAntigo = nomes.get("nomeAntigo");
        String nomeNovo = nomes.get("nomeNovo");

        if (nomeAntigo == null || nomeNovo == null) {
            return ResponseEntity.badRequest().build();
        }

        portfolioService.atualizarNomeAluno(nomeAntigo, nomeNovo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarNomePortfolio(@RequestBody Map<String, String> payload) {
        String nomeAntigo = payload.get("nomeAntigo");
        String nomeNovo = payload.get("nomeNovo");
        portfolioService.atualizarNomePortfolio(nomeAntigo, nomeNovo);
        return ResponseEntity.noContent().build();
    }

}
