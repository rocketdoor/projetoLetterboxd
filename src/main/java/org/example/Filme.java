package org.example;

public class Filme
{
    int id;
    String titulo;
    String diretor;
    int anoLancamento;
    boolean assistido;
    int nota;

    public Filme(String titulo, String diretor, int anoLancamento) {
        this.id = -1;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.assistido = false;
        this.nota = -1;
    }

    public String getTitulo() {
        return titulo;
    }
    public int getId(){
        return id;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getNota() {
        return nota;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    public void setNota(int nota) {
        this.nota = nota;
        if (nota < 0)
        {
            throw new IllegalArgumentException("Nota não pode ser negativa");
        }
    }

    void setId(int id)
    {
        this.id = id;

        if (id < 0)
        {
            throw new IllegalArgumentException("ID não pode ser negativo");
        }
    }
}
