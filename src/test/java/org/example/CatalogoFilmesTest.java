package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoFilmesTest {

    @Test
    void adicionarFilme()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        catalogo.adicionarFilme(filme1);

        assertEquals(filme1, catalogo.getFilmes()[0]);
    }

    @Test
    void getFilmes()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);
        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);

        Filme[] filmes = catalogo.getFilmes();

        assertEquals(filme1, filmes[0]);
        assertEquals(filme2, filmes[1]);
    }

    @Test
    void adicionarFilmeAteLimite()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        for (int i = 0; i < 100; i++) {
            catalogo.adicionarFilme(new Filme("Filme " + i, "Diretor " + i, 2000 + i));
        }

        assertEquals(100, catalogo.getFilmes().length);
    }

    @Test
    void adicionarFilmeAlemLimite()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        for (int i = 0; i < 100; i++) {
            catalogo.adicionarFilme(new Filme("Filme " + i, "Diretor " + i, 2000 + i));
        }

        assertThrows(IllegalStateException.class, () -> {
            catalogo.adicionarFilme(new Filme("Filme Extra", "Diretor Extra", 2025));
        });
    }

    @Test
    void adicionarNaoFilme()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        int filme = 0;

        assertThrows(NullPointerException.class, () -> {
            catalogo.adicionarFilme(null);
        });
    }
}