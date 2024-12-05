package br.insper.entidades.usuario_gestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GestorService {

    @Autowired
    private GestorRepository GestorRepository;

    public  RetornarGestorDTO cadastraGestor(CadastraGestorDTO dto){
            Gestor gestor = new Gestor();
            gestor.setNome(dto.nome());
            gestor.setSenha(dto.senha());
            gestor.setEmail(dto.email());
            return new RetornarGestorDTO(gestor.getId(), gestor.getNome(),
                    gestor.getSenha(), gestor.getEmail());
    }

    public Gestor validaGestor(String nome, String senha) {
        Gestor gestor = GestorRepository.findByNome(nome);
        if (gestor != null && gestor.getSenha().equals(senha)) {
            return gestor;
        }
        return null;
    }


}
