package br.com.sixtechsolutions.model.dominio;

public class Jogada {

    private String nome;
    private int pontos;
    private int acertos;
    private int erros;

    public Jogada(String nome, int pontos, int acertos, int erros) {
        this.nome = nome;
        this.pontos = pontos;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Jogada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

}
