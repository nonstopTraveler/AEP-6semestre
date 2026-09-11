package com.aep.ler.controller;

import com.aep.ler.model.Livro;
import com.aep.ler.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LivroControllerTest {

    @Mock
    private LivroService livroService;

    @InjectMocks
    private LivroController livroController;

    private Livro livro;

    @BeforeEach
    void setUp() {
        livro = new Livro();
        livro.setId("1");
        livro.setTitulo("O Cortiço");
        livro.setAutor("Aluísio Azevedo");
    }

    @Test
    void testListarTodos() {
        when(livroService.listarTodos()).thenReturn(Arrays.asList(livro));

        List<Livro> resultado = livroController.listarTodos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(livroService, times(1)).listarTodos();
    }

    @Test
    void testBuscarPorIdSucesso() {
        when(livroService.buscarPorId("1")).thenReturn(livro);

        Livro response = livroController.buscarPorId("1");

        assertNotNull(response);
        assertEquals("O Cortiço", response.getTitulo());
        verify(livroService, times(1)).buscarPorId("1");
    }

    @Test
    void testBuscarPorIdNaoEncontrado() {
        when(livroService.buscarPorId("99")).thenReturn(null);

        Livro response = livroController.buscarPorId("99");

        assertNull(response);
        verify(livroService, times(1)).buscarPorId("99");
    }

    @Test
    void testSalvar() {
        when(livroService.cadastrar(any(Livro.class))).thenReturn(livro);

        Livro resultado = livroController.cadastrar(livro);

        assertNotNull(resultado);
        assertEquals("O Cortiço", resultado.getTitulo());
    }

    @Test
    void testDeletar() {
        when(livroService.excluir("1")).thenReturn(true); // ou "Sucesso", etc.

        assertDoesNotThrow(() -> livroController.excluir("1"));

        verify(livroService, times(1)).excluir("1");
    }
}