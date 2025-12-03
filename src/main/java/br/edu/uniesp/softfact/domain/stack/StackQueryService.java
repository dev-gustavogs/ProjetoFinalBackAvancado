package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.shared.enums.Categoria;

import java.util.List;

public interface StackQueryService {
    List<StackEntity> findAll();
    StackEntity findById(Long id);
    StackEntity findByNome(String nome);
    List<StackEntity> findByCategoria(Categoria categoria);
}