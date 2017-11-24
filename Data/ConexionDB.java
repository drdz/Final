package Data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
     private static Connection conexion;
    
    private void abrirConexion() throws SQLException{
        String dbURI = "jdbc:derby://localhost:1527/DOOFINAL";
        String username = "";
        String password = "";
        conexion = DriverManager.getConnection(dbURI, username, password);
        
    }
    
     private void cerrarConexion() throws SQLException{
        conexion.close();
    }  
}
