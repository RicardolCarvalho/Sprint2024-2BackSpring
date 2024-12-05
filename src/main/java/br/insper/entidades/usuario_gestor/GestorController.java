package br.insper.entidades.usuario_gestor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/gestores")
public class GestorController {

    @Autowired
    private GestorService GestorService;

    @PostMapping("/login")
    public ResponseEntity<?> loginGestor(@RequestBody Map<String, String> loginRequest) {
        String nome = loginRequest.get("nome");
        String senha = loginRequest.get("senha");

        Gestor gestor = GestorService.validaGestor(nome, senha);
        if (gestor == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
        return ResponseEntity.ok(Map.of(
                "id", gestor.getId(),
                "nome", gestor.getNome()
        ));
    }


    @ResponseStatus(HttpStatus.CREATED)
    public RetornarGestorDTO cadastraGestor(@Valid @RequestBody CadastraGestorDTO gestorDTO){
        return GestorService.cadastraGestor(gestorDTO);
    }
}
