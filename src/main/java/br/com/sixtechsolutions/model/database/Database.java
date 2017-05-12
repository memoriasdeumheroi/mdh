
package br.com.sixtechsolutions.model.database;

import java.sql.Connection;


public interface Database {
    
    public Connection conectar();
    public void desconectar(Connection conexao);
    
}
