/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidad.Utilidad.Log;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Conexion_DB {
    public Connection AbrirConexion() throws Exception 
    {
        Connection con=null;  // instacia una conexión
        try {
           Class.forName("com.mysql.jdbc.Driver");  // Cargar el driver
           String urlOdbc = "jdbc:mysql://localhost:3306/ClientesDB";
           con=(java.sql.DriverManager.getConnection(urlOdbc,"root",""));  //crea conexión
           return con;
         } catch(Exception e){//SQLException y ClassNotFoundException
            Log.getInstance().error(e);
            throw new Exception("Ha sido imposible establecer la conexion"+e.getMessage());
         }          
    }
    
    public Connection AbrirConexionDS() throws Exception 
    {
        Connection con=null;  // instacia una conexión
        try {
           Context ctx = new InitialContext();
           DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/clienteDS");
           con  = ds.getConnection(); 
           return con;
         } catch(Exception e){//SQLException y ClassNotFoundException
            Log.getInstance().error(e);
            throw new Exception("Ha sido imposible establecer la conexion desde DataSource"+e.getMessage());
         }          
    }
    public Connection AbrirConexionDSAlt() throws Exception 
    {
        Connection con=null;  // instacia una conexión
        try {
           Context ctx = new InitialContext();
           DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/clientesDSAlt");
           con  = ds.getConnection(); 
           return con;
         } catch(Exception e){//SQLException y ClassNotFoundException
            Log.getInstance().error(e);
            throw new Exception("Ha sido imposible establecer la conexion desde DataSource"+e.getMessage());
         }          
    }
    
    public  void CerrarConexion(Connection con) throws Exception
    {
        try {
             if (con!= null) con.close();    
        } catch (SQLException e) {
            Log.getInstance().error(e);
            throw new Exception("Ha sido imposible cerrar la conexion"+e.getMessage());
        }    
        }    
}
