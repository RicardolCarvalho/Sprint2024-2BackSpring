package br.insper.entidades.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public RetornaAlunoDTO cadastraAluno(CadastraAlunoDTO dto){
        Aluno alunoDB = alunoRepository.findByCpf(dto.cpf());

        if(alunoDB == null){
            Aluno aluno = new Aluno();
            aluno.setNome(dto.nome());
            aluno.setFiliacao1(dto.filiacao1());
            aluno.setFiliacao2(dto.filiacao2());
            aluno.setNomeSocialAluno(dto.nomeSocialAluno());
            aluno.setNomeAfetivoAluno(dto.nomeAfetivoAluno());
            aluno.setDataNascimento(dto.dataNascimento());
            aluno.setCpf(dto.cpf());
            aluno.setRg(dto.rg());
            aluno.setCodigoAluno(dto.codigoAluno());
            aluno.setCodigoInep(dto.codigoInep());
            aluno.setTurma(dto.turma());
            aluno = alunoRepository.save(aluno);
            return new RetornaAlunoDTO(aluno.getNome(), aluno.getFiliacao1(),
                    aluno.getFiliacao2(), aluno.getNomeSocialAluno(),
                    aluno.getNomeAfetivoAluno(), aluno.getDataNascimento(),
                    aluno.getCpf(), aluno.getRg(), aluno.getCodigoAluno(),
                    aluno.getCodigoInep(), aluno.getTurma());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Aluno buscarAluno(String id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public void excluirAluno(String id){
        Aluno aluno = buscarAluno(id);
        alunoRepository.delete(aluno);
    }

    public List<Aluno> listarAlunos(String nomeTurma, String nomeAluno){

        if (nomeTurma != null){
            return alunoRepository.findByTurma(nomeTurma);
        } else if (nomeAluno != null) {
            List<Aluno> alunos = new ArrayList<>();
            alunos.add(alunoRepository.findByNomeStartingWith(nomeAluno));
            return alunos;
        }
        return  alunoRepository.findAll();
    }

    public RetornaAlunoDTO editarAluno(String id, EditarAlunoDTO dto) {

        Aluno aluno = buscarAluno(id);

        if (dto.nome() != null && (!dto.nome().equals("None"))) {
            aluno.setNome(dto.nome());
        }
        if (dto.filiacao1() != null && (!dto.filiacao1().equals("None"))) {
            aluno.setFiliacao1(dto.filiacao1());
        }
        if (dto.filiacao2() != null && (!dto.filiacao2().equals("None"))) {
            aluno.setFiliacao2(dto.filiacao2());
        }
        if (dto.nomeSocialAluno() != null && (!dto.nomeSocialAluno().equals("None"))) {
            aluno.setNomeSocialAluno(dto.nomeSocialAluno());
        }
        if (dto.nomeAfetivoAluno() != null && (!dto.nomeAfetivoAluno().equals("None"))) {
            aluno.setNomeAfetivoAluno(dto.nomeAfetivoAluno());
        }
        if (dto.dataNascimento() != null && (!dto.dataNascimento().equals("None"))) {
            aluno.setDataNascimento(dto.dataNascimento());
        }
        if (dto.cpf() != null && (!dto.cpf().equals("None"))) {
            aluno.setCpf(dto.cpf());
        }
        if (dto.rg() != null && (!dto.rg().equals("None"))) {
            aluno.setRg(dto.rg());
        }
        if (dto.codigoAluno() != null && (!dto.codigoAluno().equals("None"))) {
            aluno.setCodigoAluno(dto.codigoAluno());
        }
        if (dto.codigoInep() != null && (!dto.codigoInep().equals("None"))) {
            aluno.setCodigoInep(dto.codigoInep());
        }
        if (dto.turma() != null && (!dto.turma().equals("None"))) {
            aluno.setTurma(dto.turma());
        }

        aluno = alunoRepository.save(aluno);

        return new RetornaAlunoDTO(
                aluno.getNome(),
                aluno.getFiliacao1(),
                aluno.getFiliacao2(),
                aluno.getNomeSocialAluno(),
                aluno.getNomeAfetivoAluno(),
                aluno.getDataNascimento(),
                aluno.getCpf(),
                aluno.getRg(),
                aluno.getCodigoAluno(),
                aluno.getCodigoInep(),
                aluno.getTurma()
        );
    }

    public Aluno getAlunoById(String id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado para o ID: " + id));
    }
}
