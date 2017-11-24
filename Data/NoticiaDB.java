
package Data;

import Modelo.Comentario;
import Modelo.Noticia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class NoticiaDB {
    private static Connection conexion;
    public static List beanss;
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
     public static void insertar( Noticia articulo){

        try {

            abrirConexion();
            PreparedStatement stmt;
            String sql = "INSERT INTO NOTICIA(TITULO,CONTENIDO,IDCATEGORIA,IMAGEN) VALUES (?,?,?,?)";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, articulo.getTitulo());
            stmt.setString(2, articulo.getDescripcion());
            stmt.setInt(3, articulo.getId_categoria());
            stmt.setString(4, articulo.getUrl_Imagen());
         

            stmt.executeUpdate();

            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static List<Noticia> noticias (){
              ResultSet resultados;
        List<Noticia> beans = new ArrayList();
        
        PreparedStatement ps = null;
        try {
            abrirConexion();

            String sql = "select * from NOTICIA";

            ps = conexion.prepareStatement(sql);

            resultados = ps.executeQuery();

            while (resultados.next()) {
             
                String titulo = resultados.getString("TITULO");
                int idNoiticia = resultados.getInt("IDNOTICIA");
                String descripcion = resultados.getString("CONTENIDO");
                String urlImagen = resultados.getString("IMAGEN");
                int idcategoria = Integer.parseInt(resultados.getString("IDCATEGORIA"));
            

                Noticia bean = new Noticia(idNoiticia,titulo,descripcion,urlImagen,idcategoria);
                

                beans.add(bean);
            
            }

            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
     }
public static List<Noticia> getNoticiasbyId (int categoria){
        ResultSet resultados;
        List<Noticia> beans = new ArrayList();
        
        PreparedStatement ps = null;
        try {
            abrirConexion();

            String sql = "select * from NOTICIA where IDCATEGORIA="+categoria;

            ps = conexion.prepareStatement(sql);

            resultados = ps.executeQuery();

            while (resultados.next()) {
             
                String titulo = resultados.getString("TITULO");
                int idNoiticia = resultados.getInt("IDNOTICIA");
                String descripcion = resultados.getString("CONTENIDO");
                String urlImagen = resultados.getString("IMAGEN");
                int idcategoria = Integer.parseInt(resultados.getString("IDCATEGORIA"));
            

                Noticia bean = new Noticia(idNoiticia,titulo,descripcion,urlImagen,idcategoria);
                

                beans.add(bean);
            
            }

            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(NoticiaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
     }
    public static boolean comentar(Comentario com) {
        try {
            abrirConexion();

            String cadena = "INSERT into APP.COMENTARIO(CONTENIDO, IDUSUARIO, IDNOTICIA) values('" +com.getContenido()+ "'," + com.getIdusuario()+ "," + com.getIdnoticia()+ ")";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(cadena);
            conexion.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }

    public static boolean eliminarNoticia(int id) {
         try {
            abrirConexion();

            String cadena = "DELETE FROM  APP.NOTICIA WHERE IDNOTICIA="+id ;
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(cadena);
            conexion.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }

    public static Noticia getNoticia(int id) {
    abrirConexion();
       
        boolean bo=false;
        String sql = " select * from APP.NOTICIA where IDNOTICIA= ?";
        PreparedStatement ps;
        try {
           Noticia us = null;
       
            ps = conexion.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
       
     if(rs.next()){
      String titulo=rs.getString(2);
      int idNoticia=rs.getInt(1);
      String contenido=rs.getString(3);
      us=new Noticia(id,titulo,contenido);
     }
           
      
      
        conexion.close();
        return us;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
 }

    public static boolean editar(Noticia noticia) {
        try {
            abrirConexion();

            String cadena = 
                    " UPDATE APP.NOTICIA" +
                    " SET TITULO ='" +noticia.getTitulo()+"', "+
                    "CONTENIDO = '"+noticia.getDescripcion()+"'"+
                    "WHERE IDNOTICIA="+ noticia.getIdNoticia();
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(cadena);
            conexion.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
}
