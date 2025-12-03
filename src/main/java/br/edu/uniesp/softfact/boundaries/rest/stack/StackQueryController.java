package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.infra.stack.StackEntity;
import br.edu.uniesp.softfact.shared.enums.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stacks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StackQueryController {

    private final StackQueryService stackQueryService;

    @GetMapping
    public ResponseEntity<List<StackEntity>> findAll() {
        List<StackEntity> stacks = stackQueryService.findAll();
        return ResponseEntity.ok(stacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StackEntity> findById(@PathVariable Long id) {
        try {
            StackEntity stack = stackQueryService.findById(id);
            return ResponseEntity.ok(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<StackEntity> findByNome(@PathVariable String nome) {
        try {
            StackEntity stack = stackQueryService.findByNome(nome);
            return ResponseEntity.ok(stack);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<StackEntity>> findByCategoria(@PathVariable Categoria categoria) {
        List<StackEntity> stacks = stackQueryService.findByCategoria(categoria);
        return ResponseEntity.ok(stacks);
    }
}