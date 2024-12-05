package br.insper.entidades.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public RetornarProfessorDTO cadastraProfessor(CadastraProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.nome());
        professor.setJornada(dto.jornada());
        professor.setCurricular(dto.curricular());
        professor.setAcumulo(dto.acumulo());
        professor.setProjetos(dto.projetos());
        professor.setTurmas(dto.turmas());
        professor.setAtivo(dto.ativo());
        professor = professorRepository.save(professor);
        return new RetornarProfessorDTO(professor.getId(), professor.getNome(),
                professor.getAcumulo(), professor.getJornada(), professor.getCurricular(), professor.getTurmas(),
                professor.getProjetos(), professor.getAtivo());
    }

    public Page<Professor> listarProfessores(String nome, Boolean ativo, Pageable pageable) {
        if (nome != null && ativo != null) {
            return professorRepository.findByNomeContainingAndAtivo(nome, ativo, pageable);
        } else if (nome != null) {
            return professorRepository.findByNomeContaining(nome, pageable);
        } else if (ativo != null) {
            return professorRepository.findByAtivo(ativo, pageable);
        }
        return professorRepository.findAll(pageable);
    }

    public Professor buscarProfessor(String id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void excluirProfessor(String id) {
        Professor professor = buscarProfessor(id);
        professorRepository.delete(professor);
    }

    public RetornarProfessorDTO atualizarProfessor(String id, CadastraProfessorDTO dto) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor not found"));

        // Atualiza apenas os campos fornecidos na DTO
        if (dto.nome() != null) professor.setNome(dto.nome());
        if (dto.jornada() != null) professor.setJornada(dto.jornada());
        if (dto.curricular() != null) professor.setCurricular(dto.curricular());
        if (dto.acumulo() != null) professor.setAcumulo(dto.acumulo());
        if (dto.turmas() != null) professor.setTurmas(dto.turmas());
        if (dto.projetos() != null) professor.setProjetos(dto.projetos());
        if (dto.ativo() != null) professor.setAtivo(dto.ativo());  // Atualiza o status ativo

        professor = professorRepository.save(professor);
        return new RetornarProfessorDTO(
                professor.getId(),
                professor.getNome(),
                professor.getAcumulo(),
                professor.getJornada(),
                professor.getCurricular(),
                professor.getTurmas(),
                professor.getProjetos(),
                professor.getAtivo()
        );
    }
}

