package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.shared.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<StackEntity, Long> {

    Optional<StackEntity> findByNome(String nome);

    List<StackEntity> findByCategoria(Categoria categoria);

    boolean existsByNome(String nome);
}