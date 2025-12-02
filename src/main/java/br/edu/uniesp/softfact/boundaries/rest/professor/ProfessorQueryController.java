package br.edu.uniesp.softfact.boundaries.rest.professor;

import br.edu.uniesp.softfact.application.professor.ProfessorResponse;
import br.edu.uniesp.softfact.domain.professor.ProfessorQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
public class ProfessorQueryController {

    private final ProfessorQueryService service;

    @GetMapping("/{id}")
    public ProfessorResponse buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public Page<ProfessorResponse> listar(@RequestParam(required = false) String query, Pageable pageable) {
        return service.listar(query, pageable);
    }
}

