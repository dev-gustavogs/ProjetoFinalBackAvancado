package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.infra.stack.StackEntity;

public interface StackCommandService {
    StackEntity create(StackCreateRequest request);
    StackEntity update(Long id, StackUpdateRequest request);
    void delete(Long id);
}