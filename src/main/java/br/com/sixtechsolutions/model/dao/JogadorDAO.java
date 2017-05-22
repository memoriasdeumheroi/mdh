package br.com.sixtechsolutions.model.dao;

import br.com.sixtechsolutions.model.dominio.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                jogador.setNome(resultado.getString("nome"));
                jogador.setSexo("sexo");
                jogador.setNivel(Integer.parseInt("nivel"));
                jogador.setExperiencia(Integer.parseInt("experiencia"));
                jogador.setIdPersonagem(Integer.parseInt("id_personagem"));
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

}
