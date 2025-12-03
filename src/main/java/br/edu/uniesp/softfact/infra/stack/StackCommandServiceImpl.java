package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.StackCommandService;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.infra.stack.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StackCommandServiceImpl implements StackCommandService {

    private final StackRepository stackRepository;

    @Override
    @Transactional
    public StackEntity create(StackCreateRequest request) {
        if (stackRepository.existsByNome(request.getNome())) {
            throw new IllegalArgumentException("Stack com nome '" + request.getNome() + "' já existe");
        }

        StackEntity stack = StackEntity.builder()
                .nome(request.getNome())
                .categoria(request.getCategoria())
                .build();

        return stackRepository.save(stack);
    }

    @Override
    @Transactional
    public StackEntity update(Long id, StackUpdateRequest request) {
        StackEntity stack = stackRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stack não encontrada"));

        if (request.getNome() != null && !request.getNome().equals(stack.getNome())) {
            if (stackRepository.existsByNome(request.getNome())) {
                throw new IllegalArgumentException("Stack com nome '" + request.getNome() + "' já existe");
            }
            stack.setNome(request.getNome());
        }

        if (request.getCategoria() != null) {
            stack.setCategoria(request.getCategoria());
        }

        return stackRepository.save(stack);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!stackRepository.existsById(id)) {
            throw new IllegalArgumentException("Stack não encontrada");
        }
        stackRepository.deleteById(id);
    }
}