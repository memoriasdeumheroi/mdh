package br.com.sixtechsolutions.controller.logica;

import br.com.sixtechsolutions.model.dominio.Jogador;

public class JogadorEstatico {

    private static String nome;
    private static String sexo;
    private static String login;
    private static String senha;
    private static int nivel;
    private static int experiencia;
    private static int idPersonagem;

    public JogadorEstatico(Jogador jogador) {
        this.nome = jogador.getNome();
        this.sexo = jogador.getSexo();
        this.login = jogador.getLogin();
        this.senha = jogador.getSenha();
        this.nivel = jogador.getNivel();
        this.experiencia = jogador.getExperiencia();
        this.idPersonagem = jogador.getIdPersonagem();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(int idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

}
