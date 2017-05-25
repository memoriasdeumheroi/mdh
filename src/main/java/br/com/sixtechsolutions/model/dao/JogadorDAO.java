package br.com.sixtechsolutions.model.dao;

import br.com.sixtechsolutions.model.dominio.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JogadorDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Jogador jogador) {
        String comandoSQL = "INSERT INTO JOGADOR(USUARIO, SENHA, NOME, SEXO, NIVEL, EXPERIENCIA, ID_PERSONAGEM)"
                + " values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(comandoSQL);
            stmt.setString(1, jogador.getLogin());
            stmt.setString(2, jogador.getSenha());
            stmt.setString(3, jogador.getNome());
            stmt.setString(4, jogador.getSexo());
            stmt.setString(5, String.valueOf(jogador.getNivel()));
            stmt.setString(6, String.valueOf(jogador.getExperiencia()));
            stmt.setString(7, String.valueOf(jogador.getIdPersonagem()));
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Jogador jogador) throws SQLException {
        String comandoSQL = "UPDATE jogador SET usuario=?, login=?, senha=? WHERE login=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(comandoSQL);
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getLogin());
            stmt.setString(3, jogador.getSenha());
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Jogador buscar(Jogador jogador) {
        String sql = "SELECT * FROM JOGADOR WHERE usuario=? and senha=?";
        Jogador retorno = new Jogador();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jogador.getLogin());
            stmt.setString(2, jogador.getSenha());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                jogador.setLogin(resultado.getString("usuario"));
                jogador.setSenha(resultado.getString("senha"));
                retorno = jogador;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean usuarioExiste(String usuario) {
        String sql = "SELECT * FROM JOGADOR WHERE usuario=?";
        String select = null;
        boolean retorno = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                select = resultado.getString("usuario");
                if (select.equals(usuario)) {
                    retorno = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Jogador buscarDadosDoJogador(String login) {
        String sql = "SELECT * FROM JOGADOR WHERE USUARIO=?";
        Jogador retorno = new Jogador();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                retorno.setLogin(resultado.getString("USUARIO"));
                retorno.setSenha(resultado.getString("SENHA"));
                retorno.setNome(resultado.getString("NOME"));
                retorno.setSexo(resultado.getString("SEXO"));
                retorno.setNivel(Integer.parseInt(resultado.getString("NIVEL")));
                retorno.setExperiencia(Integer.parseInt(resultado.getString("EXPERIENCIA")));
                retorno.setIdPersonagem(Integer.parseInt(resultado.getString("ID_PERSONAGEM")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public List<Jogador> listar() {
        String sql = "SELECT * FROM JOGADA ORDER BY QTD_PONTOS DESC LIMIT 10";
        List<Jogador> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Jogador jogador = new Jogador();
                jogador.setNome(resultado.getString("NOME_USUARIO"));
                jogador.setPontos(Integer.parseInt(resultado.getString("QTD_PONTOS")));
                retorno.add(jogador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserirJogada(String nome, int qtdAcertos, int qtdErros, int qtdPontos) {
        String comandoSQL = "INSERT INTO JOGADA(QTD_ACERTOS, QTD_ERROS, QTD_PONTOS, NOME_USUARIO)"
                + " values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(comandoSQL);
            stmt.setString(1, String.valueOf(qtdAcertos));
            stmt.setString(2, String.valueOf(qtdErros));
            stmt.setString(3, String.valueOf(qtdPontos));
            stmt.setString(4, nome);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
