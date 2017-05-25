package br.com.sixtechsolutions.model.dominio;

public class Jogador {

    private String nome;
    private String sexo;
    private String login;
    private String senha;
    private int nivel;
    private int pontos;
    private int experiencia;
    private int idPersonagem;

    public Jogador() {

    }

    public Jogador(String nome, String sexo, String login, String senha,
            int nivel, int experiencia, int idPersonagem) {
        this.nome = nome;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.idPersonagem = idPersonagem;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
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
