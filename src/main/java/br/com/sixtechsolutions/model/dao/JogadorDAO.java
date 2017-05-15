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
        String comandoSQL = "INSERT INTO jogador(login, senha, nome, sexo) values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(comandoSQL);
            stmt.setString(1, jogador.getLogin());
            stmt.setString(2, jogador.getSenha());
            stmt.setString(3, jogador.getNome());
            stmt.setString(4, jogador.getSexo());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Jogador jogador) throws SQLException {
        String comandoSQL = "UPDATE jogador SET nome=?, login=?, senha=? WHERE login=?";
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
        String sql = "SELECT * FROM clientes WHERE cdCliente=?";
        Jogador retorno = new Jogador();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jogador.getLogin());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                jogador.setLogin(resultado.getString("login"));
                jogador.setSenha(resultado.getString("senha"));
                retorno = jogador;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
