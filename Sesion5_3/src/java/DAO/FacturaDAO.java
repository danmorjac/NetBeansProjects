/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Articulo;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FacturaDAO {

    public Factura creaFactura(Connection con,Factura factura, Cliente cliente) throws Exception
{   PreparedStatement stmt=null;
    try {                         
            stmt = con.prepareStatement("INSERT INTO Factura (idFactura,Cliente_DNI, Fecha) " +
                    " VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);       
            stmt.setObject(1, null);
            stmt.setInt(2,cliente.getDNI());
            stmt.setInt(3,factura.getFecha());
            stmt.executeUpdate();
            ResultSet rs=stmt.getGeneratedKeys();
            rs.next();
            int key=rs.getInt(1);
            factura.setIdFactura(key);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al crear la factura "+ex.getMessage());
        } finally
        {
            if (stmt != null) stmt.close();//Cerramos el Statement
        }    
        return factura;
}       

    public void addArticulo(Connection con,Factura factura, Articulo articulo,int numero) throws Exception
{   PreparedStatement stmt=null;
    try {                         
            stmt = con.prepareStatement("INSERT INTO articulo_factura (Articulo_idArticulo, Factura_idFactura, Numero) " +
                    " VALUES(?,?,?)");
            stmt.setInt(1,articulo.getIdArticulo());
            stmt.setInt(2,factura.getIdFactura());
            stmt.setInt(3,numero);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al añadir el articulo a la factura "+ex.getMessage());
        } finally
        {
            if (stmt != null) stmt.close();//Cerramos el Statement
        }    
}   
    
}
