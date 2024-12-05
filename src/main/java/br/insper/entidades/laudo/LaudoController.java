package br.insper.entidades.laudo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laudos")
public class LaudoController {

    private final LaudoService laudoService;
    @Autowired
    private LaudoRepository laudoRepository;

    public LaudoController(LaudoService laudoService) {
        this.laudoService = laudoService;
    }

    @PostMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> salvarLaudo(@PathVariable String alunoId, @RequestParam("file") MultipartFile file) {
        try {
            laudoService.salvarLaudo(alunoId, file);
            return ResponseEntity.ok("Laudo salvo com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar o laudo: " + e.getMessage());
        }
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<?> getLaudos(@PathVariable String alunoId) {
        try {
            List<Laudo> laudos = laudoRepository.findAllByAlunoId(alunoId);
            List<Map<String, String>> response = laudos.stream().map(laudo -> {
                Map<String, String> laudoInfo = new HashMap<>();
                laudoInfo.put("id", laudo.getId());
                laudoInfo.put("fileName", laudo.getFileName());
                laudoInfo.put("downloadUrl", "/laudos/id/" + laudo.getId());
                return laudoInfo;
            }).collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar laudos: " + e.getMessage());
        }
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deletarLaudo(@PathVariable String id) {
        try {
            laudoService.deletarLaudo(id);
            return ResponseEntity.ok("Laudo deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<byte[]> getLaudoById(@PathVariable String id) {
        try {
            Laudo laudo = laudoService.buscarLaudoPorId(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + laudo.getFileName() + "\"")
                    .body(laudo.getFileContent());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}