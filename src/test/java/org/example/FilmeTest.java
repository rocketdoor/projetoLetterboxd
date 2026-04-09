package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {

    @org.junit.jupiter.api.Test
    void getTitulo() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertEquals("O Poderoso Chefão", filme.getTitulo());
    }

    @org.junit.jupiter.api.Test
    void getDiretor() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertEquals("Francis Ford Coppola", filme.getDiretor());
    }

    @org.junit.jupiter.api.Test
    void getAnoLancamento() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertEquals(1972, filme.getAnoLancamento());
    }

    @org.junit.jupiter.api.Test
    void getNota() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertEquals(-1, filme.getNota());
    }

    @org.junit.jupiter.api.Test
    void isAssistido() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertFalse(filme.isAssistido());
    }

    @org.junit.jupiter.api.Test
    void setAssistido() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        filme.setAssistido(true);
        assertTrue(filme.isAssistido());
    }

    @org.junit.jupiter.api.Test
    void setNota() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        filme.setNota(9);
        assertEquals(9, filme.getNota());
    }

    @org.junit.jupiter.api.Test
    void testNegativeNota() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            filme.setNota(-5);
        });

        assertEquals("Nota não pode ser negativa", exception.getMessage());

    }

    @Test
    void testNotaString() {
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        assertThrows(NumberFormatException.class, () -> {
            filme.setNota(Integer.parseInt("nota"));
        });
    }

    @Test
    void testConstrutorErrado()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            new Filme("", "Francis Ford Coppola", 1972);
        });
    }
}