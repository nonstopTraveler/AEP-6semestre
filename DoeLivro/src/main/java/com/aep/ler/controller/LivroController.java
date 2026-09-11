package com.aep.ler.controller;

import com.aep.ler.model.Livro;
import com.aep.ler.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    // CREATE
    @PostMapping
    public Livro cadastrar(@Valid @RequestBody Livro livro) {
        return livroService.cadastrar(livro);
    }

    // READ - todos
    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    // READ - por ID
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable String id) {
        return livroService.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Livro atualizar(
            @PathVariable String id,
            @Valid @RequestBody Livro livro) {

        return livroService.atualizar(id, livro);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable String id) {

        boolean excluido = livroService.excluir(id);

        if (excluido) {
            return "Livro excluído com sucesso";
        }

        return "Livro não encontrado";
    }
}