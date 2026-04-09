package org.example;

public class Main {
    public static void main(String[] args)
    {
        Filme filme1 = new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972);
        Filme filme2 = new Filme("Pulp Fiction", "Quentin Tarantino", 1994);
        Filme filme3 = new Filme("A Origem", "Christopher Nolan", 2010);

        CatalogoFilmes catalogo = new CatalogoFilmes();
        catalogo.adicionarFilme(filme1);
        catalogo.adicionarFilme(filme2);
        catalogo.adicionarFilme(filme3);

        System.out.println("Catálogo de Filmes:");
        for (Filme filme : catalogo.getFilmes()) {
            System.out.println("- " + filme.getTitulo() + " (" + filme.getAnoLancamento() + ")");
        }
    }
}