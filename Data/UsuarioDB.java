package Data;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UsuarioDB {
    private static Connection conexion;
    private static void abrirConexion(){
        String dbURI = "jdbc:derby://localhost:1527/DOOFINAL";
        String username = "";
        String password = "";
        try {
            conexion = DriverManager.getConnection(dbURI);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    public static  boolean registroUsuario(Usuario user){
        
    
        try {
            abrirConexion();

            String cadena = "INSERT into APP.USERS (EMAIL,PASSWORD,NAME,TIPOUSUARIO) values ('" +user.getEmail()+ "','" + user.getPassword() + "','" + user.getName()+ "',"+user.getTipoUsuario()+")";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(cadena);
            conexion.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    
   public static Usuario login(Usuario user) {
        abrirConexion();
       
        boolean bo=false;
        String sql = " select * from APP.USERS where EMAIL= ?  and PASSWORD= ?";
        PreparedStatement ps;
        try {
            Usuario us = null;
       
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
       
     if(rs.next()){
      String s=rs.getString(2);
      int i=rs.getInt(1);
      boolean b=rs.getBoolean(3);
      String name=rs.getString("NAME");
      us=new Usuario(s,i,b,name);
     }
     else
     {
         int a = 1;
         a= 2;
     }
           
      
      
        conexion.close();
        return us;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
