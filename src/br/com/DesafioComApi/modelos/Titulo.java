package br.com.DesafioComApi.modelos;

public class Titulo {
    private String Titulo; // O nome deve corresponder ao JSON
    private String Ano;
    private String Duracao;
    private String Genero;
    private String Diretor;
    private String Sinopse;

    public Titulo(String titulo, String ano, String duracao, String genero, String diretor, String sinopse) {
        Titulo = titulo;
        Ano = ano;
        Duracao = duracao;
        Genero = genero;
        Diretor = diretor;
        Sinopse = sinopse;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAno() {
        return Ano;
    }

    public String getDuração() {
        return Duracao;
    }

    public String getGenero() {
        return Genero;
    }

    public String getDiretor() {
        return Diretor;
    }

    public String getSinopse() {
        return Sinopse;
    }

    @Override
    public String toString() {
        return "Título: " + Titulo +
                ", Ano: " + Ano +
                ", Duração: " + Duracao +
                ", Gênero: " + Genero +
                ", Diretor: " + Diretor +
                ", Sinopse: " + Sinopse;
    }
}