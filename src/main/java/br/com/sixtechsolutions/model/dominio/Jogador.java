package br.com.sixtechsolutions.model.dominio;

public class Jogador {

    private String nome;
    private String sexo;
    private String login;
    private String senha;
    private String personagem;

    public Jogador(String nome, String sexo, String login, String senha) {
        this.nome = nome;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
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

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

}
