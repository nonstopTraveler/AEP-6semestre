package com.aep.ler.service;

import com.aep.ler.model.Livro;
import com.aep.ler.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // CREATE
    public Livro cadastrar(Livro livro) {
        return livroRepository.save(livro);
    }

    // READ - todos
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // READ - por ID
    public Livro buscarPorId(String id) {
        return livroRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Livro atualizar(String id, Livro livro) {

        Livro livroExistente = livroRepository.findById(id).orElse(null);

        if (livroExistente == null) {
            return null;
        }

        livroExistente.setTitulo(livro.getTitulo());
        livroExistente.setAutor(livro.getAutor());
        livroExistente.setCategoria(livro.getCategoria());
        livroExistente.setEstadoConservacao(livro.getEstadoConservacao());
        livroExistente.setDisponivel(livro.isDisponivel());

        return livroRepository.save(livroExistente);
    }

    // DELETE
    public boolean excluir(String id) {

        if (!livroRepository.existsById(id)) {
            return false;
        }

        livroRepository.deleteById(id);
        return true;
    }
}