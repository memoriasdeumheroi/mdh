package br.com.sixtechsolutions.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMySQL implements Database {

    private Connection connection;

    @Override
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/mdh", "root", "root");
            System.out.println("Conectado!");
            return this.connection;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possivel se conectar ao banco!");
            return null;
        }
    }

    @Override
    public void desconectar(Connection conexao) {
        try {
            this.connection.close();
            System.out.println("Desconectado!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possivel desconectar!");
        }
    }
}
