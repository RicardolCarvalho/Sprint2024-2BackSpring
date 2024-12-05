package br.insper.entidades.turma;

import br.insper.entidades.aluno.Aluno;
import br.insper.entidades.aluno.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.ArrayList;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public RetornarTurmaDTO cadastraTurma(CadastraTurmaDTO dto){
        Turma turmaDB = turmaRepository.findByNomeTurma(dto.nomeTurma());
        if (turmaDB == null){
            Turma turma = new Turma();
            turma.setNomeTurma(dto.nomeTurma());
            turma.setAno(dto.anoTurma());
            turmaRepository.save(turma);
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();
            for (String nome : dto.alunos()) {
                if (alunoRepository.findByNome(nome) == null){
                    Aluno aluno = new Aluno();
                    aluno.setNome(nome);
                    aluno.setTurma(dto.nomeTurma());
                    alunoRepository.save(aluno);
                    alunos.add(aluno);
                }
            }
            return new RetornarTurmaDTO(alunos, turma);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<Turma> listarTurmas(String ano, String nomeTurma){
        if (ano != null){
            return turmaRepository.findByAno(ano);
        } else if (nomeTurma != null) {
            List<Turma> turmas = new ArrayList<>();
            turmas.add(turmaRepository.findByNomeTurmaStartingWith(nomeTurma));
            return turmas;
        }
        return turmaRepository.findAll();
    }

    public Turma buscarTurma(String id){
        return turmaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public RetornarTurmaEdicaoDTO editarTurma(String id, EditarTurmaDTO editarTurmaDTO){
        Turma turma = buscarTurma(id);
        if (editarTurmaDTO.nomeTurma() != null){
            turma.setNomeTurma(editarTurmaDTO.nomeTurma());
        }
        if(editarTurmaDTO.anoTurma() != null){
            turma.setAno(editarTurmaDTO.anoTurma());
        }
        turma = turmaRepository.save(turma);
        return new RetornarTurmaEdicaoDTO(turma);
    }
}
