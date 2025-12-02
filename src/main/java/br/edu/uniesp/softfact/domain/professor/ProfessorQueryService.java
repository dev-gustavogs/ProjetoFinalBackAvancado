package br.edu.uniesp.softfact.domain.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorQueryService {

    ProfessorResponse buscarPorId(Long id);

    Page<ProfessorResponse> listar(String termo, Pageable pageable);
}
