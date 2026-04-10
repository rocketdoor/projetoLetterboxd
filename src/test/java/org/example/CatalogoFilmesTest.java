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
    void buscarFilmesPorTitulo() {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorTitulo("O Poderoso Chefão");

        assertTrue(filmesEncontrados[0].getTitulo().equalsIgnoreCase("O Poderoso Chefão"));
    }

    @Test
    void buscarTituloRepetido() {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("Kill Bill", "Tentin Quarantino", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorTitulo("Kill Bill");

        assertTrue(filmesEncontrados[0].getDiretor().equalsIgnoreCase("Tentin Quarantino"));
        assertTrue(filmesEncontrados[1].getDiretor().equalsIgnoreCase("Quentin Tarantino"));
    }

    @Test
    void buscaFalha()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorTitulo("Inception");

        assertEquals(0, filmesEncontrados.length);
    }

    @Test
    void buscarFilmesPorDiretor() {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorDiretor("Francis Ford Coppola");

        assertTrue(filmesEncontrados[0].getTitulo().equalsIgnoreCase("O Poderoso Chefão"));
    }

    @Test
    void buscarDiretorRepetido() {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("Bill Kill", "Tentin Quarantino", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorDiretor("Quentin Tarantino");

        assertTrue(filmesEncontrados[0].getTitulo().equalsIgnoreCase("Kill Bill"));
        assertTrue(filmesEncontrados[1].getTitulo().equalsIgnoreCase("Pulp Fiction"));
    }

    @Test
    void buscaFalhaDiretor()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        Filme[] filmesEncontrados = catalogo.buscarFilmesPorDiretor("Paul Thomas Anderson");

        assertEquals(0, filmesEncontrados.length);
    }

    @Test
    void testIdCatalogo()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);

        catalogo.adicionarFilme(filme);

        assertEquals(0, filme.getId());
    }

    @Test
    void testDelete()
    {
        CatalogoFilmes catalogo = new CatalogoFilmes();
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Kill Bill", "Quentin Tarantino", 2006);
        Filme filme3 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);

        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        catalogo.removerFilmePorId(1);

        assertEquals(filme3, catalogo.getFilmes()[1]);
    }
}