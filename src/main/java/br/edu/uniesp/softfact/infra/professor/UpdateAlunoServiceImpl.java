package br.edu.uniesp.softfact.infra.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.domain.professor.Professor;
import br.edu.uniesp.softfact.domain.professor.UpdateProfessorService;
import br.edu.uniesp.softfact.infra.mapper.ProfessorEntityMapper;
import br.edu.uniesp.softfact.zo.old.stack.StackTecRepository;
import br.edu.uniesp.softfact.zo.old.stack.StackTecnologia;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateProfessorServiceImpl implements UpdateProfessorService {

    private final ProfessorRepository repo;
    private final StackTecRepository stackRepo;
    private final ProfessorEntityMapper entityMapper;

    @Override
    public ProfessorResponse criar(Professor dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado.");
        }
        return entityMapper.toResponse(repo.save(entityMapper.toEntity(dto)));
    }

    @Override
    public ProfessorResponse atualizar(Long id, Professor dto) {
        ProfessorEntity existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado: " + id));

        if (!existente.getEmail().equalsIgnoreCase(dto.getEmail()) && repo.existsByEmail(dto.getEmail())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado.");
        }

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
        existente.setArea(dto.getArea());
        existente.setFormacao(dto.getFormacao());
        existente.setStacks(buscarStacks(dto.getStacks().stream().map(StackTecnologia::getId).collect(Collectors.toSet())));

        return entityMapper.toResponse(existente);
    }

    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) throw new EntityNotFoundException("Professor não encontrado: " + id);
        repo.deleteById(id);
    }

    private Set<StackTecnologia> buscarStacks(Set<Long> ids) {
        if (ids == null || ids.isEmpty()) return Set.of();
        return ids.stream()
                .map(id -> stackRepo.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Stack não encontrada: " + id)))
                .collect(Collectors.toSet());
    }
}

