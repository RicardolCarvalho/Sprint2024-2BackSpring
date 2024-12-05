package br.insper.entidades.laudo;

import br.insper.entidades.aluno.Aluno;
import br.insper.entidades.aluno.AlunoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LaudoService {

    private final LaudoRepository laudoRepository;
    private final AlunoRepository alunoRepository;

    public LaudoService(LaudoRepository laudoRepository, AlunoRepository alunoRepository) {
        this.laudoRepository = laudoRepository;
        this.alunoRepository = alunoRepository;
    }

    public void salvarLaudo(String alunoId, MultipartFile file) throws IOException {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + alunoId));

        Laudo laudo = new Laudo();
        laudo.setAlunoId(aluno.getId());
        laudo.setFileName(file.getOriginalFilename());
        laudo.setFileContent(file.getBytes());
        laudoRepository.save(laudo);
    }

    public List<Laudo> buscarLaudosPorAluno(String alunoId) {
        return laudoRepository.findAllByAlunoId(alunoId);
    }


    public void deletarLaudo(String id) {
        Laudo laudo = laudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum laudo encontrado para o aluno com ID: " + id));
        laudoRepository.delete(laudo);
    }

    public Laudo buscarLaudoPorId(String id) {
        return laudoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laudo não encontrado com ID: " + id));
    }

}
