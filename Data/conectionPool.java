
package Data;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public  class conectionPool {
    
    private static conectionPool pool =null;
    private static DataSource data = null;
    
    public synchronized static conectionPool getInstancia(){
    if(pool==null){
    pool=new conectionPool();
    }
    return pool;
    }
    private conectionPool(){

    try{
    InitialContext ic = new InitialContext();
    data = (DataSource) ic.lookup("jdbc:derby://localhost:1527/DOOFINAL");
    
}catch(Exception ex){
    ex.printStackTrace();
}
    }

public Connection getConexion(){
    try{
    return data.getConnection();
    
    }catch (SQLException ex){
    ex.printStackTrace();
    return null;
    }
    
    
}
public void liberarConexion(Connection c) {
    
    try{
    if (c !=null)
        c.close();  
    }catch (SQLException ex){
    ex.printStackTrace();
    }

}
}

