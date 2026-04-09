package org.example;

public class CatalogoFilmes
{
    private Filme[] filmes;
    private int quantidadeFilmes;

    public CatalogoFilmes() {
        this.filmes = new Filme[100]; // Capacidade inicial para 100 filmes
        this.quantidadeFilmes = 0;
    }

    public void adicionarFilme(Filme filme) {
        if (quantidadeFilmes < filmes.length) {
            filmes[quantidadeFilmes] = filme;
            quantidadeFilmes++;
        } else {
            throw new IllegalStateException("Capacidade máxima de filmes atingida");
        }
    }

    public Filme[] getFilmes(){
        return filmes;
    }
}
