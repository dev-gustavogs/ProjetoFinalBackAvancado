package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import br.edu.uniesp.softfact.shared.enums.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StackQueryServiceImpl implements StackQueryService {

    private final StackRepository stackRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StackEntity> findAll() {
        return stackRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public StackEntity findById(Long id) {
        return stackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public StackEntity findByNome(String nome) {
        return stackRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StackEntity> findByCategoria(Categoria categoria) {
        return stackRepository.findByCategoria(categoria);
    }
}