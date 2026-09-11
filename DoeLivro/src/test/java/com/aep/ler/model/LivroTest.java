package com.aep.ler.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void testConstrutorVazioEGettersSetters() {
        Livro livro = new Livro();
        livro.setId("1");
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setCategoria("Romance");
        livro.setEstadoConservacao("Novo");
        livro.setDisponivel(true);

        assertEquals("1", livro.getId());
        assertEquals("Dom Casmurro", livro.getTitulo());
        assertEquals("Machado de Assis", livro.getAutor());
        assertEquals("Romance", livro.getCategoria());
        assertEquals("Novo", livro.getEstadoConservacao());
        assertTrue(livro.isDisponivel());
    }

    @Test
    void testConstrutorComParametros() {
        Livro livro = new Livro("O Cortiço", "Aluísio Azevedo", "Romance", "Usado", false);

        assertNull(livro.getId());
        assertEquals("O Cortiço", livro.getTitulo());
        assertEquals("Aluísio Azevedo", livro.getAutor());
        assertEquals("Romance", livro.getCategoria());
        assertEquals("Usado", livro.getEstadoConservacao());
        assertFalse(livro.isDisponivel());
    }
}