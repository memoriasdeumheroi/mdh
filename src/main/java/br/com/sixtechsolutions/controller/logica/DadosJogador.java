package br.com.sixtechsolutions.controller.logica;

import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.sql.Connection;

public class DadosJogador {

    private static String login;
    private static String nome;
    private static String sexo;
    private static int nivel;
    private static int experiencia;
    private static int idPersonagem;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();

    public static String getLogin() {
        return login;
    }

    public static String getNome() {
        return nome;
    }

    public static String getSexo() {
        return sexo;
    }

    public static int getNivel() {
        return nivel;
    }

    public static int getExperiencia() {
        return experiencia;
    }

    public static int getIdPersonagem() {
        return idPersonagem;
    }

    public void pegarDadosDoJogador(String login) {
        jogadorDAO.setConnection(connection);
        Jogador jogador;
        jogador = jogadorDAO.buscarDadosDoJogador(login);
        this.login = jogador.getLogin();
        this.nome = jogador.getNome();
        this.sexo = jogador.getSexo();
        this.nivel = jogador.getNivel();
        this.experiencia = jogador.getExperiencia();
        this.idPersonagem = jogador.getIdPersonagem();
    }

}
