package org.example;

import java.util.ArrayList;
import java.util.List;

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
            filmes[quantidadeFilmes].setId(quantidadeFilmes);
            quantidadeFilmes++;
        } else {
            throw new IllegalStateException("Capacidade máxima de filmes atingida");
        }
    }


    public Filme[] buscarFilmesPorTitulo(String titulo) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        for (int i = 0; i < quantidadeFilmes; i++) {
            if (filmes[i].getTitulo().equalsIgnoreCase(titulo)) {
                filmesEncontrados.add(filmes[i]);
            }
        }
        return filmesEncontrados.toArray(new Filme[0]);
    }

    public Filme[] buscarFilmesPorDiretor(String diretor) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        for (int i = 0; i < quantidadeFilmes; i++) {
            if (filmes[i].getDiretor().equalsIgnoreCase(diretor)) {
                filmesEncontrados.add(filmes[i]);
            }
        }
        return filmesEncontrados.toArray(new Filme[0]);
    }

    public void removerFilmePorId(int id) {
        for (int i = 0; i < quantidadeFilmes; i++) {
            if (filmes[i].getId() == id) {
                for (int j = i; j < quantidadeFilmes - 1; j++) {
                    filmes[j] = filmes[j + 1];
                }

                filmes[quantidadeFilmes - 1] = null;
                quantidadeFilmes--;
                return;
            }
        }
        throw new IllegalArgumentException("Filme com o ID '" + id + "' não encontrado.");
    }

    public Filme[] getFilmes()
    {
        return filmes;
    }
}
