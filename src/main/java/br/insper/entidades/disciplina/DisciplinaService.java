package br.insper.entidades.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public RetornarDisciplinaDTO cadastrarDisciplina(CadastrarDisciplinaDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.nome());
        disciplina.setAlunos(dto.alunos());

        disciplina = disciplinaRepository.save(disciplina);

        return new RetornarDisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getAlunos()
        );
    }

    public List<RetornarDisciplinaDTO> listarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        List<RetornarDisciplinaDTO> retorno = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            retorno.add(new RetornarDisciplinaDTO(
                    disciplina.getId(),
                    disciplina.getNome(),
                    disciplina.getAlunos()
            ));
        }

        return retorno;
    }

    public RetornarDisciplinaDTO buscarDisciplina(String id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));

        return new RetornarDisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getAlunos()
        );
    }

    public RetornarDisciplinaDTO atualizarDisciplina(String id, CadastrarDisciplinaDTO dto) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));

        disciplina.setNome(dto.nome());
        disciplina.setAlunos(dto.alunos());

        disciplina = disciplinaRepository.save(disciplina);

        return new RetornarDisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getAlunos()
        );
    }

    public void excluirDisciplina(String id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada"));

        disciplinaRepository.delete(disciplina);
    }
}
