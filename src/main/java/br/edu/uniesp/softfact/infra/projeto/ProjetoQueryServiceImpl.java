package br.edu.uniesp.softfact.infra.projeto;

import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.domain.projeto.ProjetoQueryService;
import br.edu.uniesp.softfact.infra.mapper.ProjetoEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjetoQueryServiceImpl implements ProjetoQueryService {

    private final ProjetoRepository repository;

    @Override
    public Projeto findById(Long id) {
        return repository.findById(id)
                .map(ProjetoEntityMapper::toDomain)
                .orElse(null);
    }
}
